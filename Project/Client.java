import java.net.*;
import java.io.*;

public class Client
{
    private int serverPort;
    private String hostName;
    //private final int PORTNUM = 1001;
    private Socket sockClient;
    private OutputStream outToServer;
    private DataOutputStream messenger;
    public Client( String initServerName, int initServerPort )
    {
        serverPort = initServerPort;
        hostName = initServerName;
        try
        {
            sockClient = new Socket( hostName, serverPort );
            outToServer = sockClient.getOutputStream();
            messenger = new DataOutputStream( outToServer );
        }catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    public void sendMsg( String msg )
    {
        try
        {
            messenger.writeUTF( msg );
        }catch(IOException e )
        {
            e.printStackTrace();
        }
    }
}