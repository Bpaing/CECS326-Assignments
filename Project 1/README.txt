This README is for running the programs in a Windows command line terminal.

To compile:
Place the included files into a folder.
Open command line and set the current directory to the folder where files are contained.
    Example:    cd [directory of files]

If Java is correctly set up on your computer, run these commands:

    Q1:     javac -d . QuoteServer.java
            javac -d . QuoteClient.java

    Q2:     javac -d . EchoServer.java
            javac -d . EchoClient.java

This will compile the class files and place them into their respective package folders.



To run:
Because Server and Client are treated as different runtimes, this will require two separate command line terminals.
Open command line and set the current directory to the folder where the .java files are contained (both terminals).

Use the following template to run a java file:

    java [packageName].[fileName] (without .java)

    Example:    java questionOne.QuoteServer

Ideally, one terminal will be running a server while the other will be running a client.
