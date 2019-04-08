import java.awt.event.*;
import javax.swing.JButton;

public class ButtonUser implements ActionListener
{
    private JButton button1, button2;

    // Assume all code to create and set up the buttons is complete.

    // Method to produce two different messages, depending upon which of the two
    // buttons is pressed.
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == button1 )
        {
            System.out.println( "Eggs Eggs Eggs!" );
        }
        else if ( e.getSource() == button2 )
        {
            System.out.println( "I'm starving to death for some eggs!" );
        }
    }
}