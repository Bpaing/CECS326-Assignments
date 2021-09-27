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
            BufferedReader fileRead = new BufferedReader(new FileReader(file));
            List<String> quotes = new ArrayList<>();
            String str = fileRead.readLine();
            while (str != null){
                quotes.add(str);
                str = fileRead.readLine();
            }
            fileRead.close();

            ServerSocket sock = new ServerSocket(6017);
            System.out.println("Server started.");

            while (true) {
                Socket client = sock.accept();
                System.out.println("New client accepted.");

                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);

                pout.println(quotes.get((int)(Math.random()*quotes.size())));

                client.close();
            }

        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
