package prog.concur.projet.client;

import java.net.*;
import java.io.*;

public class TelnetClient
{
	private int port;
	
	public TelnetClient(int p){
		this.port = p;
		try {
			this.client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void client() throws Exception{
		
		Socket clientSocket = new Socket("localhost", this.port);		   
		
        DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        System.out.println("Welcome to Telnet Client");
        
        dout.writeBytes("bonjour" + '\n');
        
        System.out.println(inFromServer.readLine());

        clientSocket.close();        
	}
}
