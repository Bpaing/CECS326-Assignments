package questionOne;
import java.net.*;
import java.io.*;

class DateServer
{
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket sock = new ServerSocket(6017);
            System.out.println("Server Started");
            while (true) {
                Socket client = sock.accept();

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
