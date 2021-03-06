package questionTwo;

import java.net.*;
import java.io.*;
public class EchoServer {
	
	public static void main (String[] args) throws IOException {
		try {
			ServerSocket sock = new ServerSocket(0125);

			while(true) {
				Socket client = sock.accept();
				System.out.println("Client connected.");

				//Objects to send and receive data
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

				//Echo the data received back to client
				String inputReceival;
				while((inputReceival = in.readLine()) != null) {
					pout.println(inputReceival);		
				}
			
				client.close();
				sock.close();
			}		
		}
		catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}				
	}
}