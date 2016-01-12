package prog.concur.projet.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class TelnetServerBasNiveau implements Runnable
{
	private int nbConn;
	private int tempsInactif;
	private int port;
	
	public TelnetServerBasNiveau(int n, int ti, int p){
		this.nbConn = n;
		this.tempsInactif = ti;
		this.port = p;
	}
	
	public void createServeur() throws Exception {
		ServerSocket serverSocket = new ServerSocket(this.port);
		int nbClient = 0;
	
		while (nbClient < this.nbConn) {
	        // a "blocking" call which waits until a connection is requested
	        Socket clientSocket = serverSocket.accept();
	        nbClient++;
	        System.err.println("Accepted connection from client");
	        this.dialogWithClient(clientSocket);	        
		}
	}
	
	public void dialogWithClient(Socket s) throws Exception{
		BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    DataOutputStream dataOutputClient = new DataOutputStream(s.getOutputStream());
	    
	    String recu = null;
	    System.out.println("Un client !");
	    
        while (brClient.readLine() != null) {
        	System.out.println(brClient.readLine());
        	/*System.out.println("Recu: " + recu);
    	    dataOutputClient.writeBytes(recu);*/
        }

        /*System.err.println("Closing connection with client");
        out.close();
        in.close();
        clientSocket.close();*/
	}

	public void run() {
		try {
			this.createServeur();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}