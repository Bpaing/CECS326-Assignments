This README is for running the programs in a Windows command line terminal.

To compile:
Place the included files into a folder.
Open command line and set the current directory to the folder where files are contained.
    Example:    cd [directory of files]

If Java is correctly set up on your computer, run this command:
    
    javac -d . Driver.java CPU.java Algorithm.java Task.java FCFS.java Priority.java RR.java

This will compile the class files for each java file.


To run:
Open command line and set the current directory to the folder where the .java files are contained.

Use the following template to run a java file:
    	
    java Driver <algorithm> <schedule>
        <algorithm> :   FCFS    = First Come First Serve
                        PRI     = Priority
                        RR      = Round Robin

        <schedule> should be the name of the text file containing the formatted schedule.

        Each line of the text file instantiates a Task to add to the scheduling queue.
        Tasks should be specified in the following format in the text file:
                        [Name], [Priority], [Burst Time]
                        String, int, int


    Example:    java Driver FCFS schedule.txt

Alternatively, the Project can be opened on an IDE compatible with Java. 
The IDE can either open it, or the contents of the source code can be copy/pasted in a new project.
Make sure that the java files are linked to each other correctly, and then set up a configuration running Driver with
the specified arguments.