#!/usr/bin/perl -w
###############################################################################
# Authors: Allie Sauppe, Jason Sauppe                                         #
# Date: 2016-09-12                                                            #
# File: tester.pl                                                             #
# Usage: ./tester                                                             #
###############################################################################
use strict;
use IO::File;
use Text::Tabs;
use File::Copy;

sub test_program;
sub run_test_case;
sub run_java_program;
sub print_test_sep;
sub print_test_msg;

### Global variables
my $teacher_report_filehandle;  # File handle for full output
my $student_report_filehandle;  # File handle for output visible to student

my $total_points = 0;           # Sum of test case points
my %test_case_points = ();      # Hash of points per test case
my %student_notes = ();         # Notes to print to student at end of report;
                                # Using a hash to avoid repeated outputs

### Constants and configuration settings
my $class = 'FlushLeft';
my $solution_dir = './solution';
my $student_dir = './student';
my $java = 'java';
#'/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.65-2.b17.el7_1.x86_64/jre/bin/java';

# Output settings
my $output_width = 190;
my $half_width = $output_width / 2;
my $omit_student = 0;

# Enums
my $report_to_teacher = 0;
my $report_to_student = 1;
my $report_to_both = 2;

#main
{
    test_program();

    ### TODO: Do output stuff here...
    #print_student_report();
}

#------------------------------------------------------------------------------
sub test_program {

    ### Create output filehandles
    open($teacher_report_filehandle, "> teacher-report.txt") or
        die("Unable to open teacher report output file: $!\n");
    open($student_report_filehandle, "> student-report.txt") or
        die("Unable to open student report output file: $!\n");

    ### Testing code
    print_test_msg("Executing tests for $class", $report_to_both);

    ###  testCaseLabel pts visibleToStudent inputArgs
    run_test_case('test1', 1, 1, ['An example string to print out to the console.', '15']);
    run_test_case('test2', 1, 1, ['four char test', '4']);
    run_test_case('test3', 1, 1, ['A short sentence', '20']);
    run_test_case('test4', 1, 1, ['four char test part deux', '7']);
    run_test_case('test5', 1, 1, ['four char test part deux', '8']);
    run_test_case('test6', 1, 1, ['four char test part deux', '9']);
    run_test_case('test7', 1, 1, ['four char test part deux', '10']);

    # Print sep at end
    print_test_sep($report_to_both);

    ### Allow for post-processing of test cases
    # Use test case labels to post-process in some way; maybe award some
    # points back to certain test cases depending on severity of mismatch


    ### Determine grade from test case points and output to reports
    my $points_earned = 0;
    foreach my $points (values %test_case_points) {
        $points_earned += $points;
    }
    print_test_msg("Points: $points_earned / $total_points\n", $report_to_both);
    foreach my $student_note (keys %student_notes) {
        print_test_msg($student_note . "\n", $report_to_both);
    }

    ### Output for Autolab
    print_test_msg("" . ('-' x $output_width) . "\n", $report_to_both);
    print_test_msg("Output for Autolab:\n", $report_to_both);
    print_test_msg("{\"scores\": {\"Correctness\": $points_earned}}\n",
                   $report_to_both);

    ### Cleanup
    close($student_report_filehandle);
    close($teacher_report_filehandle);
    # Remove output files created for each test case
    foreach my $label (keys(%test_case_points)) {
        unlink("$solution_dir/output-$label.txt",
               "$student_dir/output-$label.txt",
               "comp-$label.txt");
    }

    return;
}

#------------------------------------------------------------------------------
sub run_test_case {
    my $label = shift();
    my $points = shift();
    my $show_to_student = shift();
    my $input_ref = shift();

    ### Determine who gets to see the output from this test case
    my $report_option =
        ($show_to_student) ? $report_to_both : $report_to_teacher;
    my $output_file = "output-$label.txt";
    $total_points += $points;

    ### Print test details to appropriate report file(s)
    print_test_sep($report_option);
    print_test_msg("Input Arguments: " . join(', ', @{$input_ref}) . "\n",
                   $report_option);
    print_test_msg(sprintf("%-${half_width}s%s\n",
                           '** Expected **', '** Actual **'), $report_option);
    print_test_msg("" . ('-' x $output_width) . "\n", $report_option);

    ### Generate solution output
    run_java_program("-cp $solution_dir $class",
                     "$solution_dir/$output_file", $input_ref);

    ### Generate student output
    if ($omit_student || !(-e "$student_dir/$class.class")) {
        # Don't generate student output in this case
        open(my $fh, '>', "$student_dir/$output_file") or
            die("Unable to create student output file: $!\n");
        print $fh "Student code omitted\n";
        close($fh);
    } else {
        # Run student code and create output
        my $their_class = $class; # For correcting misnamed classes
        run_java_program("-cp $student_dir $their_class",
                         "$student_dir/$output_file", $input_ref);
    }

    ### Generate comparison of solution output and student output
    my $diff_cmd = 'diff'
                 . " $solution_dir/$output_file"
                 . " $student_dir/$output_file"
                 . " -y -W $output_width";
    my $diff_return = system("$diff_cmd > comp-$label.txt");
    my $diff_return_ignore_whitespace = system("$diff_cmd -w > /dev/null");

    ### Record all-or-nothing points in hash
    if (exists $test_case_points{$label}) {
        die("Duplicate label for test case: $label\n")
    }
    $test_case_points{$label} = ($diff_return == 0) ? $points : 0;
    if ($diff_return_ignore_whitespace == 0 && $diff_return != 0) {
        my $msg = "Mismatch in whitespace for output";
        if (!(exists $student_notes{$msg})) {
            $student_notes{$msg} = 0;
        }
        $student_notes{$msg} += 1;
    }

    ### Read lines from comparison file and append to report(s)
    open(FI, "< comp-$label.txt") or die("Unable to open comp file: $!\n");
    while (my $line = <FI>) {
        print_test_msg(expand($line), $report_option);
    }
    close(FI);
    # Print newline to make sure we have a clean break
    print_test_msg("\n" . ('-' x $output_width) . "\n", $report_option);

    # Clean up temporary output files
    #unlink("$solution_dir/output.txt", "$student_dir/output.txt", "comp.txt");

    return;
}

#------------------------------------------------------------------------------
sub run_java_program {
    my $java_args = shift();
    my $output_file = shift();
    my $input_ref = shift();

    ### Method 1
    my $tpa = IO::File->new("| $java $java_args > $output_file 2>&1") or
        die("Error: $!\n");
    $tpa->print(join("\n", @{$input_ref}) . "\n");
    $tpa->close();
    # sed magic to fix issues with missing newlines in student output
    `sed -i '/^##/!s/\\(.\\)##/\\1\\n##/' $output_file`;

    ### Remove newlines at end of file
    `perl -pi -e 'chomp if eof' $output_file`;

    ### Method 2
    #my $tpa = IO::File->new("| $java $java_args > $output_file 2>&1") or
    #    die("Error: $!\n");
    #foreach my $input (@{$input_ref}) {
    #    $tpa->print($input . "\n");
    #    `echo "$input\n" >> $solution_dir/output.txt`;
    #}
    #$tpa->close();

    ### Method 3 (experimental, attempting to enable dialogue with process)
    ### TODO: See if this can be implemented; seems like it should be doable
    ### http://aaroncrane.co.uk/talks/pipes_and_processes/paper.html
    ### Requires IO::Select and IPC::Open3
    #my $java_in; my $java_out; my $java_err;
    #my $childpid = open3($java_in, $java_out, $java_err,
    #                     "$java $java_args");
    #my $sel = IO::Select->new($java_in, $java_err);
    #foreach my $input (@{$input_ref}) {
    #    # Grab output from Java prog until it stops printing (or 5 seconds up)
    #    while (my @fhs = $sel->can_read(5)) {
    #        foreach my $fh (@fhs) {
    #            my $line = <$fh>;
    #            print "OUTPUT: [$line]\n";
    #        }
    #    }
    #    # Now print input to the Java prog
    #    print $java_in, $input . "\n";
    #}

    return;
}


#------------------------------------------------------------------------------
sub print_test_sep {
    my $option = shift();
    if ($option == $report_to_teacher || $option == $report_to_both) {
        print $teacher_report_filehandle "\n" . ('=' x $output_width) . "\n";
    }
    if ($option == $report_to_student || $option == $report_to_both) {
        print $student_report_filehandle "\n" . ('=' x $output_width) . "\n";
    }
}

sub print_test_msg {
    my $msg = shift();
    my $option = shift();
    if ($option == $report_to_teacher || $option == $report_to_both) {
        print $teacher_report_filehandle $msg;
    }
    if ($option == $report_to_student || $option == $report_to_both) {
        print $student_report_filehandle $msg;
    }
}

