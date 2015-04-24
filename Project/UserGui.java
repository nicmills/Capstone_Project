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
import java.awt.Color;

public class UserGui
{
    JButton initializeServer, connectClient, sendMsg, encryptMsg, decryptReceivedMsg;
    JTextArea enterHostName, enterClientPort, enterServerPort, k1, k2, k3, plainMsg, encryptedMsg, rawMsg, transMsg;
    Client c1;
    Server s1;
    ClickListener listener;
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
        frame.setSize( 650, 725 );

        //Center the Window
        frame.setLocationRelativeTo(null);

        //Initialize Panel Object
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground( Color.BLACK );

        //add panel to frame
        frame.add(panel);

        //Buttons to Initialize Servers and Connect Corresponding Clients
        initializeServer = new JButton( "Click to Initialize Server" );
        initializeServer .setBounds( 50, 50, 200, 50 );
        panel.add( initializeServer );

        connectClient = new JButton( "Click To Connect Client");
        connectClient.setBounds( 50, 125, 200, 50);
        panel.add( connectClient );

        //Buttons deal with sending and receiving Messages
        sendMsg = new JButton("Send Message");
        sendMsg.setBounds( 50, 400, 200, 50);
        panel.add( sendMsg );

        encryptMsg = new JButton("Encrypt Message");
        encryptMsg.setBounds(50, 500, 200, 50);
        panel.add( encryptMsg );

        decryptReceivedMsg = new JButton("Decrypt Received Message");
        decryptReceivedMsg.setBounds(50, 600, 200, 50);
        panel.add( decryptReceivedMsg );

        //Initialize and add the ClickListener object to the buttons
        listener = new ClickListener( this );
        initializeServer.addActionListener( listener );
        connectClient.addActionListener( listener );
        sendMsg.addActionListener( listener );
        encryptMsg.addActionListener( listener );
        decryptReceivedMsg.addActionListener( listener );

        //Fields to enter information about other computer
        enterHostName = new JTextArea( "Enter Host Name" );
        enterHostName.setBounds(50, 225, 200, 25);
        enterHostName.setVisible(true);
        enterHostName.setLineWrap(true);
        panel.add( enterHostName );

        enterClientPort = new JTextArea( "Enter Client Port" );
        enterClientPort.setBounds(50, 275, 200, 25);
        enterClientPort.setVisible(true);
        enterClientPort.setLineWrap(true);
        panel.add( enterClientPort );

        enterServerPort = new JTextArea( "Enter Server Port" );
        enterServerPort.setBounds(50, 325, 200, 25);
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
        encryptedMsg.setBounds( 300, 350, 150, 225 );
        encryptedMsg.setVisible(true);
        encryptedMsg.setLineWrap(true);
        panel.add( encryptedMsg );

        //Fields to display the received messages
        rawMsg = new JTextArea( "Raw Message" );
        rawMsg.setBounds( 475, 100, 150, 225);
        rawMsg.setVisible(true);
        rawMsg.setLineWrap(true);
        panel.add( rawMsg );

        transMsg = new JTextArea( "Translated Message" );
        transMsg.setBounds( 475, 350, 150, 225);
        transMsg.setVisible(true);
        transMsg.setLineWrap(true);
        panel.add( transMsg );
    }

    public void insertReceivedMsg( String receivedMsg )
    {
        rawMsg.setText( receivedMsg );
    }

    public class ClickListener implements ActionListener
    {
        UserGui g1;

        public ClickListener( UserGui g )
        {
            g1 = g;
        }

        public void actionPerformed( ActionEvent event )
        {
            if( event.getSource() == initializeServer )
            {
                try
                {
                    int clientPort = Integer.parseInt( enterClientPort.getText() );
                    s1 = new Server( clientPort, g1 );
                }catch(IOException e )
                {
                    e.printStackTrace();
                }
            }
            if( event.getSource() == connectClient )
            {
                int serverPort = Integer.parseInt( enterServerPort.getText() );
                c1 = new Client( enterHostName.getText(), serverPort  );
            }
            if( event.getSource() == sendMsg )
            {
                c1.sendMsg( plainMsg.getText() );
            }
            if( event.getSource() == encryptMsg )
            {
                //encrypter.scramble( plainMsg.getText() );
            }
            if( event.getSource() == decryptReceivedMsg )
            {
                //encrypter.unScramble( rawMsg.getText() );
            }
        }
    }
}

