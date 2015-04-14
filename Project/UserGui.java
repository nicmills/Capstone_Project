import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGui implements ActionListener
{
    public static void main(String[] args)
    {
        new UserGui();
    }
    
    public UserGui()
    {
        JFrame guiFrame = new JFrame();
        JPanel panel = new JPanel();
        //Close Program when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Private Messaging");
        guiFrame.setSize( 500, 500 );
        
        //Center the Window
        guiFrame.setLocationRelativeTo(null);
        
        /**
        INITIALIZATION OF INTERACTIVE ELEMENTS
        **/
        //Buttons deal with sending and receiving Messages
        JButton connectIP = new JButton( "Click To Attempt Connection");
        JButton sendMsg = new JButton("Send Message");
        JButton encryptMsg = new JButton("Encrypt Message");
        JButton decryptReceivedMsg = new JButton("Decrypt Received Message");
        panel.add( connectIP );
        panel.add( sendMsg );
        panel.add( encryptMsg );
        panel.add( decryptReceivedMsg );
        
        //Fields to enter target IP
        TextField enterIP = new TextField( "Enter IP", 20);
        panel.add( enterIP );
        
        //Fields for the 3 keys necessary to encrypt/decrypt messages
        TextField k1 = new TextField( "", 5 );
        TextField k2 = new TextField( "", 5 );
        TextField k3 = new TextField( "", 5 );
        panel.add( k1 );
        panel.add( k2 );
        panel.add( k3 );
        
        //Fields to compose messages
        TextField plainMsg = new TextField( "Enter Message", 40 );
        TextField encryptedMsg = new TextField( "", 40 );
        panel.add( plainMsg );
        panel.add( encryptMsg );
        
        //Fields to display the received messages
        TextField rawRecMsg = new TextField( "", 40 );
        TextField transRecMsg = new TextField( "", 40 );
        panel.add( rawRecMsg );
        panel.add( transRecMsg );
        
        
    }
    
    public void actionPerformed( ActionEvent event )
    {
        if( event.getSource() == connectIP )
        { 
        }
        else if( event.getSource() == sendMsg )
        {
        }
        else if( event.getSource() == encryptMsg )
        {
        }
        else if( event.getSource() == decryptReceivedMsg )
        {
        }
    }
}