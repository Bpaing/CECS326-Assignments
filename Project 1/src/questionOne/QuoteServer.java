package questionOne;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class QuoteServer
{
    public static void main(String[] args) throws IOException {
        try {
            File file = new File(System.getProperty("user.dir") + "\\quotes.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));

            ServerSocket sock = new ServerSocket(6017);
            System.out.println("Server started.");

            while (true) {
                Socket client = sock.accept();
                System.out.println("New client accepted.");

                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);

                pout.println(in.readLine());

                client.close();
                in.close();
            }

        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

}
