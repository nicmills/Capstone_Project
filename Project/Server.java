import java.net.*;
import java.io.*;

public class Server extends Thread
{
    private ServerSocket serverSocket;
    private String clientPort;
    //private final int PORTNUM = 1001;
    private DataInputStream receivedData;
    private UserGui localGui;
    public Server( String initClientPort, UserGui g1 ) throws IOException
    {
        serverPort = initServerPort;
        serverSocket = new ServerSocket(clientPort);
        localGui = g1;
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
                if( receivedData.readUTF() != null )
                {
                    //pass data to gui
                    localGui.insertReceivedMsg( receivedData.readUTF() );
                    
                }
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
}