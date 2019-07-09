#!/bin/bash

###############################################################################
# Authors: Allie Sauppe, Jason Sauppe                                         #
# Date: 2016-09-12                                                            #
# File: driver.sh                                                             #
# Usage: ./driver.sh                                                          #
# Description: Driver for autograding. Compiles student and solution code,    #
#   generates outputs for test cases from each program, and compares results  #
#   using diff.                                                               #
###############################################################################

# driver.sh - A modification of the simplest autograder the
#   Autolab folks could think of. It checks that students can
#   write a Java program that compiles and produces output in
#   the correct format, and then exits with an exit status of zero.

# This is the name of the Java class being tested
PROG = FlushLeft

# Compile the code (limit make's output)
echo "Compiling $PROG"
(make -s clean; make -s)
status=$?
if [ ${status} -ne 0 ]; then
    echo "Failure: Unable to compile $PROG (return status = ${status})"
    echo "{\"scores\": {\"Correctness\": 0}}"
    exit
fi

# Run the code
echo "Running tests for $PROG"
./tester.pl ## probably want to change this input of the directory

# Output student-report as Autolab output (student can see this)
cat student-report.txt

