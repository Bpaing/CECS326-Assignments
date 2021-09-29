package questionOne;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class QuoteServer
{
    public static void main(String[] args) throws IOException {
        try {
            //Setup for quote file reading
            File file = new File(System.getProperty("user.dir") + "\\quotes.txt");
            BufferedReader fileRead = new BufferedReader(new FileReader(file));
            List<String> quotes = new ArrayList<>();

            //Add quotes from file into array list
            String str = fileRead.readLine();
            while (str != null){
                quotes.add(str);
                str = fileRead.readLine();
            }
            fileRead.close();

            ServerSocket sock = new ServerSocket(6017);
            System.out.println("Server started.");

            //Send a quote to a connected client
            while (true) {
                Socket client = sock.accept();
                System.out.println("New client accepted.");

                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);

                //Send random quote from array list
                pout.println(quotes.get((int)(Math.random()*quotes.size())));

                System.out.println("Closing current connection. . .");
                client.close();
            }

        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
