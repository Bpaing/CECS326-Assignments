package questionOne;
import java.net.*;
import java.io.*;

//accept() method waits for a client to connect
class DateClient
{
    public static void main(String[] args) throws IOException {
        try {
                Socket client = new Socket("localhost", 6017);

        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}

