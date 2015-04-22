import java.net.*;
import java.io.*;

public class Server extends Thread
{
    private ServerSocket serverSocket;
    private final int PORTNUM = 1001;
    private DataInputStream receivedData;
    public Server() throws IOException
    {
        serverSocket = new ServerSocket(PORTNUM);
        serverSocket.setSoTimeout(100000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                Socket server = serverSocket.accept();
                receivedData = new DataInputStream(server.getInputStream());
                
                //pass received data to gui
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String [] args)
    {
        try
        {
            Thread t = new Server();
            t.start();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}