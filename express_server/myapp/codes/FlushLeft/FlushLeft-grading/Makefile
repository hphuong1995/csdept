#
# Makefile for building student executable and solution executable from their
# respective sources.
#
PROG = FlushLeft

# Makefile for the HelloWorld program
all:
	make solution_exe
	make student_exe

solution_exe:
	cd solution; javac $(PROG).java

student_exe:
	cd student; javac $(PROG).java

clean:
	rm -rf solution/$(PROG).class
	rm -rf student/$(PROG).class
	rm -rf *txt

