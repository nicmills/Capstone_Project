import java.net.*;
import java.io.*;

public class Client
{
    private InetAddress peerIP;
    private Socket writingSocket;

    public Client( String paramIP )
    {
        peerIP = (InetAddress)paramIP;
        //try
        //{
        //    //writingSocket = new Socket(
        //}catch(IOException e)
        //{
        //}
    }

    public void sendMsg( String msg )
    {
        
    }
    
    public String readMsg()
    {
    }
}