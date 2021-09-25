package questionOne;
import java.net.*;
import java.io.*;

class QuoteServer
{
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket sock = new ServerSocket(6017);
            System.out.println("Server started, waiting for client...");
            while (true) {
                Socket client = sock.accept();
                System.out.println("New client accepted.");

                FileInputStream quotes = new FileInputStream(new File("questionOne/quotes.txt"));
                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);

                pout.println(new java.util.Date().toString());

                client.close();
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

}
