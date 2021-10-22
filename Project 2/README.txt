This README is for running the programs in a Windows command line terminal.

To compile:
Place the included files into a folder.
Open command line and set the current directory to the folder where files are contained.
    Example:    cd [directory of files]

If Java is correctly set up on your computer, run these commands:
    
    javac -d . DiningPhilosophers.java
    javac -d . DiningServer.java
    javac -d . DiningServerImpl.java
    javac -d . Philosopher.java


This will compile the class files and place them into their respective package folders.



To run:
Open command line and set the current directory to the folder where the .java files are contained.

Use the following template to run a java file:
    	
    java [packageName].[fileName] (without .java)

    Example:    java DiningPhilosophers

Alternatively, the Project can be opened on an IDE compatible with Java. 
The IDE can either open it, or the contents of the source code can be copy/pasted in a new project.