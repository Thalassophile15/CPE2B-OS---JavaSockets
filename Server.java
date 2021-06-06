package socket;

import java.net.*;
import java.io.*;


public class Server {

	
	public static void main(String[] args) {
		
		System.out.println(">>> SERVER <<<");
		System.out.println();
		
		try {
			ServerSocket serv = new ServerSocket(5353);
			System.out.println("Server is now waiting for the Client...");
			
			Socket sct = serv.accept();
			System.out.println("The connection has now been established.");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(sct.getInputStream()));
			PrintWriter pwt = new PrintWriter(sct.getOutputStream(), true);
			
			String message = "";
			
			while (true) {
				message = br.readLine();
				System.out.println();
				System.out.println("Client: " + message);
				pwt.println(message);
		
				if(message.equalsIgnoreCase("Bye")) {
					break;
				}
			}
			
			serv.close();
			br.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}