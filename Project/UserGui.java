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
        guiFrame.setVisible( true );
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible( true );
        JPanel textFldPanel = new JPanel();
        textFldPanel.setVisible( true );
        
        //Close Program when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Private Messaging");
        guiFrame.setSize( 500, 500 );
        
        
        
        //Center the Window
        guiFrame.setLocationRelativeTo(null);
        
        
        //Buttons deal with sending and receiving Messages
        JButton connectIP = new JButton( "Click To Attempt Connection");
        connectIP.setBounds();
        buttonPanel.add( connectIP );
        
        JButton sendMsg = new JButton("Send Message");
        sendMsg.setBounds();
        guiFrame.add( sendMsg );
        
        JButton encryptMsg = new JButton("Encrypt Message");
        
        buttonPanel.add( encryptMsg );
        
        JButton decryptReceivedMsg = new JButton("Decrypt Received Message");
        
        buttonPanel.add( decryptReceivedMsg );

        
        
        //Fields to enter target IP
        TextField enterIP = new TextField( "Enter IP", 20);
        textFldPanel.add( enterIP );

        //Fields for the 3 keys necessary to encrypt/decrypt messages
        TextField k1 = new TextField( "K", 5 );
        TextField k2 = new TextField( "E", 5 );
        TextField k3 = new TextField( "Y", 5 );
        textFldPanel.add( k1 );
        textFldPanel.add( k2 );
        textFldPanel.add( k3 );

        //Fields to compose messages
        TextField plainMsg = new TextField( "Enter Message", 40 );
        TextField encryptedMsg = new TextField( "Your Encrypted Message", 40 );
        textFldPanel.add( plainMsg );
        textFldPanel.add( encryptedMsg );

        //Fields to display the received messages
        TextField rawRecMsg = new TextField( "Raw Received Message", 40 );
        TextField transRecMsg = new TextField( "Modified Received Message", 40 );
        textFldPanel.add( rawRecMsg );
        textFldPanel.add( transRecMsg );
        
        guiFrame.add( textFldPanel );
        guiFrame.add( buttonPanel );
    }
    
    public void actionPerformed( ActionEvent event )
    {
        /**
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
        */
    }
}