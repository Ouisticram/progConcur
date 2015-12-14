package test;

import java.net.*;

public class TelnetServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket Soc = new ServerSocket(5217);
        while(true)
        {
            Socket CSoc = Soc.accept();
            AcceptTelnetClient ob = new AcceptTelnetClient(CSoc);
        }
    }
}