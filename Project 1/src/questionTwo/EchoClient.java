package questionTwo;

import java.net.*;
import java.io.*;
public class EchoClient {

	public static void main(String[] args) throws IOException {
		try {
			Socket server = new Socket("localhost", 0125);
			
			PrintWriter pout = new PrintWriter(server.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String userInput;
			while((userInput = stdIn.readLine()) != null) {
				pout.println(userInput);				
				System.out.println((in.readLine()).replaceAll("(?i)Client", "Server"));			
			}
			
			server.close();
		}
		catch(UnknownHostException e){
			System.err.println(e.getMessage());
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}