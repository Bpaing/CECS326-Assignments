package questionOne;

import java.net.*;
import java.io.*;

//accept() method waits for a client to connect
class QuoteClient
{
    public static void main(String[] args) throws IOException{
        try {
            Socket client = new Socket("localhost", 6017);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(in.readLine());
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}

