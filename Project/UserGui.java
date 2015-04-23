import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class UserGui implements ActionListener
{
    JButton connectIP, sendMsg, encryptMsg, decryptReceivedMsg;
    JTextArea enterHostName, enterClientPort, enterServerPort, k1, k2, k3, plainMsg, encryptedMsg, rawMsg, transMsg;
    Client c1;
    Server s1;
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
        sendMsg.setBounds( 50, 250, 200, 100);
        panel.add( sendMsg );

        encryptMsg = new JButton("Encrypt Message");
        encryptMsg.setBounds(50, 375, 200, 100);
        panel.add( encryptMsg );

        decryptReceivedMsg = new JButton("Decrypt Received Message");
        decryptReceivedMsg.setBounds(50, 500, 200, 100);
        panel.add( decryptReceivedMsg );

        //Fields to enter target IP
        enterHostName = new JTextArea( "Enter Host Name" );
        enterHostName.setBounds(50, 100, 200, 25);
        enterHostName.setVisible(true);
        enterHostName.setLineWrap(true);
        panel.add( enterHostName );
        
        enterClientPort = new JTextArea( "Enter Client Port" );
        enterClientPort.setBounds(50, 150, 200, 25);
        enterClientPort.setVisible(true);
        enterClientPort.setLineWrap(true);
        panel.add( enterClientPort );

        enterServerPort = new JTextArea( "Enter Server Port" );
        enterServerPort.setBounds(50, 200, 200, 25);
        enterServerPort.setVisible(true);
        enterServerPort.setLineWrap(true);
        panel.add( enterServerPort );


        //Fields for the 3 keys necessary to encrypt/decrypt messages
        k1 = new JTextArea( "K" );
        k1.setBounds( 300, 50, 50, 25 );
        k1.setVisible(true);
        k1.setLineWrap(true);
        panel.add( k1 );

        k2 = new JTextArea( "E" );
        k2.setBounds( 350, 50, 50, 25 );
        k2.setVisible(true);
        k2.setLineWrap(true);
        panel.add( k2 );

        k3 = new JTextArea( "Y" );
        k3.setBounds( 400, 50, 50, 25 );
        k3.setVisible(true);
        k3.setLineWrap(true);
        panel.add( k3 );

        //Fields to compose messages
        plainMsg = new JTextArea( "Enter Message" );
        plainMsg.setBounds( 300, 100, 150, 225 );
        plainMsg.setVisible(true);
        plainMsg.setLineWrap(true);
        panel.add( plainMsg );

        encryptedMsg = new JTextArea( "Your Encrypted Message" );
        encryptedMsg.setBounds( 300, 325, 150, 225 );
        encryptedMsg.setVisible(true);
        encryptedMsg.setLineWrap(true);
        panel.add( encryptedMsg );

        //Fields to display the received messages
        rawMsg = new JTextArea( "Raw Message" );
        rawMsg.setBounds( 450, 100, 150, 225);
        rawMsg.setVisible(true);
        rawMsg.setLineWrap(true);
        panel.add( rawMsg );

        transMsg = new JTextArea( "Translated Message" );
        transMsg.setBounds( 450, 325, 150, 225);
        transMsg.setVisible(true);
        transMsg.setLineWrap(true);
        panel.add( transMsg );
    }

    public void insertReceivedMsg( String receivedMsg )
    {
        rawMsg.setText( receivedMsg );
    }

    public void actionPerformed( ActionEvent event )
    {
        if( event.getSource() == connectIP )
        {
            try
            {
                c1 = new Client( enterHostName.getText(), enterServerPort.getText() );
                s1 = new Server( enterClientPort.getText(), this );
            }catch( IOException e )
            {
                e.printStackTrace();
            }
        }
        else if( event.getSource() == sendMsg )
        {
            c1.sendMsg( plainMsg.getText() );
        }
        else if( event.getSource() == encryptMsg )
        {
            //encrypter.scramble( plainMsg.getText() );
        }
        else if( event.getSource() == decryptReceivedMsg )
        {
            //encrypter.unScramble( rawMsg.getText() );
        }
    }
}