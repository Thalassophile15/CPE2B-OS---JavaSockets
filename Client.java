package socket;

import java.net.*;
import java.util.Scanner;
import java.io.*;



public class Client {

	public static void main(String[] args) throws IOException {
		
		System.out.println(">>> CLIENT <<<");
		System.out.println();
		
		try {
			Socket st = new Socket("localhost", 5353);
			PrintWriter pwt = new PrintWriter(st.getOutputStream(),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(st.getInputStream()));
			Scanner sc = new Scanner(System.in);
			
			System.out.println("You are now connected to the server...");
			System.out.println();
			
			String msgin = "";
			while(true) {
				System.out.println("Enter message: ");
				msgin = sc.nextLine();
				pwt.println(msgin);
				String sent = br.readLine();
				System.out.println("Message sent by the Client: " + sent);
				System.out.println();
				
				if(msgin.equalsIgnoreCase("bye")) {
					break;
				}
				
				
				
			}
			System.out.println("Disconnected..");
			st.close();
			sc.close();
		
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}