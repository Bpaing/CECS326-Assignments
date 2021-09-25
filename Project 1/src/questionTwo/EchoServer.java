package questionTwo;

import java.net.*;
import java.io.*;
//import java.util.Scanner;
//import java.io.InputStream;
public class EchoServer {

    public static void main (String[] args) throws IOException {

        try {
            ServerSocket sock = new ServerSocket(0125);
            //Socket client = sock.accept();
            //server wait for client connection
            while(true) {//this should run at least once until read()
                Socket client = sock.accept();
                System.out.println("Client connected.");
                //1. Read data from the socket into a buffer.
                //2. Write the contents of the buffer back to the client.
                //Until connection closed
                //must use an object that extends java.io.InputStream.
                //read() method automatically ends when closed

                //THIS PART READS
                //must use an object that extends java.io.InputStream.
                //client.getInputStream().read();

                //Creates a new PrintWriter from Socket OutputStream.
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                //Creates a reader that can convert byte to char
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                //write data to socket
                //Scanner input = new Scanner(System.in);
                String userInput;
                while((userInput = in.readLine()) != null) {
                    pout.print(userInput);
                }

                //close socket and resume. wait for connections
                client.close();
                //input.close();
                sock.close();
            }

        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }



    }

}