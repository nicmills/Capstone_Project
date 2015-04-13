
public class UserGui
{
    public static void main(String[] args)
    {
        new UserGui();
    }
    
    public GuiApp1()
    {
        JFrame guiFrame = new JFrame();
        
        //Close Program when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Private Messaging");
        guiFrame.setSize( 500, 500 );
        
        //Center the Window
        guiFrame.setLocationRelativeTo(null);
        
        //Initialize Buttons
        JButton connectIp = new JButton( "Click To Attempt Connection");
    }
}