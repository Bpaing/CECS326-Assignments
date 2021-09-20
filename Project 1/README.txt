Question 1:
Sockets lecture describes certain port numbers as being well known—that is, they provide standard
services. Port 17 is known as the quote-of-the-day service. When a client connects to port 17 on a
server, the server responds with a quote for that day.

Modify the date server shown in Figure 1 so that it delivers a quote of the day rather than the current
date. The quotes should be printable ASCII characters and should contain fewer than 512 characters,
although  multiple  lines  are  allowed.  Since  these  well-known  ports  are  reserved  and  therefore
unavailable, have your server listen to port 6017. The date client shown in Figure 3.28 can be used
to read the quotes returned by your server.



Question 2:
An echo server echoes back whatever it receives from a client. For example, if a client sends the
server the string “Hello there! I am the client.”, the server will respond with “Hello there! I am
the server.”

Write an echo server (you can use the Java networking API). This server will wait for a client
connection using the accept() method. When a client connection is received, the server will loop,
performing the following steps:

    1. Read data from the socket into a buffer.
    2. Write the contents of the buffer back to the client.

The server will break out of the loop only when it has determined that the client has closed the
connection.

Hints: the date server of Figure 1 uses the java.io.BufferedReader class. BufferedReader extends
the java.io.Reader class, which is used for reading character streams. However, the echo server
cannot guarantee that it will read characters from clients; it may receive binary data as well. The
class java.io.InputStream deals with data at the byte level rather than the character level. Thus, your
echo  server  must  use  an  object  that  extends  java.io.InputStream.  The  read()  method  in  the
java.io.InputStream class returns −1 when the client has closed its end of the socket connection.


The Required Deliverable Materials
(1) A README file, which describes how we can compile and run your code.
(2) Your source code, you may use a Makefile (for C) and be submitted in the required format.
(3) Your short report, which discusses the design of your program.
(4) A recorded video shows the output and runtime