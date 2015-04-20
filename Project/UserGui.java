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
    JButton connectIP, sendMsg, encryptMsg, decryptReceivedMsg;
    TextField enterIP, k1, k2, k3, plainMsg, encryptedMsg, rawMsg, transMsg;
    public static void main(String[] args)
    {
        new UserGui();
    }

    public UserGui()
    {
        //Parameters for .setBounds( x, y, width, height ):
        JFrame frame = new JFrame();
        frame.setVisible( true );

        //Close Program when the panel closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Private Messaging");
        frame.setSize( 650, 650 );

        //Center the Window
        frame.setLocationRelativeTo(null);

        //Initialize Panel Object
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //add panel to frame
        frame.add(panel);

        //Buttons deal with sending and receiving Messages
        connectIP = new JButton( "Click To Attempt Connection");
        connectIP.setBounds( 50, 50, 200, 50);
        panel.add( connectIP );

        sendMsg = new JButton("Send Message");
        sendMsg.setBounds( 50, 200, 200, 100);
        panel.add( sendMsg );

        encryptMsg = new JButton("Encrypt Message");
        encryptMsg.setBounds(50,325, 200, 100);
        panel.add( encryptMsg );

        decryptReceivedMsg = new JButton("Decrypt Received Message");
        decryptReceivedMsg.setBounds(50, 450, 200, 100);
        panel.add( decryptReceivedMsg );

        
        //Fields to enter target IP
        enterIP = new TextField( "Enter IP", 20);
        enterIP.setBounds(50, 100, 200, 25);
        panel.add( enterIP );

        //Fields for the 3 keys necessary to encrypt/decrypt messages
        k1 = new TextField( "K", 5 );
        k1.setBounds( 300, 50, 50, 25 );
        panel.add( k1 );

        k2 = new TextField( "E", 5 );
         k2.setBounds( 350, 50, 50, 25 );
         panel.add( k2 );
 
        k3 = new TextField( "Y", 5 );
         k3.setBounds( 400, 50, 50, 25 );
         panel.add( k3 );
 
        //Fields to compose messages
        plainMsg = new TextField( "Enter Message", 40 );
        plainMsg.setBounds( 300, 100, 150, 225 );
        panel.add( plainMsg );

        encryptedMsg = new TextField( "Your Encrypted Message", 40 );
        encryptedMsg.setBounds( 300, 325, 150, 225 );
        panel.add( encryptedMsg );

        //Fields to display the received messages
        rawMsg = new TextField( "Raw Message", 40 );
        rawMsg.setBounds( 450, 100, 150, 225);
        panel.add( rawMsg );

        transMsg = new TextField( "Translated Message", 40 );
        transMsg.setBounds( 450, 325, 150, 225);
        panel.add( transMsg );
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