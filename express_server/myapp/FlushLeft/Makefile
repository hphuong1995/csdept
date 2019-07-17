#
# Makefile to manage building autograde.tar from testing sources
# Adapted from template provided by Autolab devs
#
# Last Modified: 2016-09-12, JJS
#

# This name should match that given in autograde-Makefile
PROG = FlushLeft

all: grading grading-tarfile

grading:
	# Rebuild the handout directory that students download
	(rm -rf $(PROG)-grading; mkdir $(PROG)-grading; mkdir $(PROG)-grading/solution; mkdir $(PROG)-grading/student)
	cp -p src/driver.sh $(PROG)-grading
	cp -p src/solution/* $(PROG)-grading/solution
	cp -p src/Makefile $(PROG)-grading/Makefile
	cp -p src/tester.pl $(PROG)-grading

grading-tarfile: grading
	# Build *-handout.tar and autograde.tar
	tar cvf autograde.tar $(PROG)-grading

clean:
	# Clean the entire lab directory tree.  Note that you can run
	# "make clean; make" at any time while the lab is live with no
	# adverse effects.
	rm -f *~ *.tar
	(cd src; make clean)
	rm -rf $(PROG)-grading
	rm -f autograde.tar

#
# CAREFULL!!! This will delete all student records in the logfile and
# in the handin directory. Don't run this once the lab has started.
# Use it to clean the directory when you are starting a new version
# of the lab from scratch, or when you are debugging the lab prior
# to releasing it to the students.
#
cleanallfiles:
	# Reset the lab from scratch.
	make clean
	rm -f log.txt
	rm -rf handin/*
