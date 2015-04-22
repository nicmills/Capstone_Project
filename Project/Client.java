import java.net.*;
import java.io.*;

public class Client
{
    private String serverName;
    private final int PORTNUM = 1001;
    private Socket sockClient;
    private OutputStream outToServer;
    private DataOutputStream messenger;
    public Client( String initServerName )
    {
        serverName = initServerName;
        try
        {
            sockClient = new Socket( serverName, PORTNUM );
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