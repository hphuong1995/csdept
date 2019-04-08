import java.awt.event.*;
import javax.swing.JFrame;

public class KeyboardUser implements KeyListener
{
    private JFrame window;
    private String[] fruit = new String[10];

    // Constructor: saves reference to input JFrame, and
    // enables KeyboardUser to respond to KeyEvents created by it.
    public KeyboardUser( JFrame win )
    {
        window = win;
        window.addKeyListener( this );
    }

    // Responds to a typed key.
    public void keyTyped( KeyEvent e )
    {
        String fruitType = "";
        
        char charTyped = e.getKeyChar();
        if ( charTyped == 'A' )
        {
            fruitType = "Apple";
        }
        else if ( charTyped == 'B' )
        {
            fruitType = "Banana!";
        }
        
        for ( int i = 0; i < fruit.length; i++ )
        {
            fruit[i] = fruitType;
        }
    }

    // Responds to press of a key; not used, but required by interface.
    public void keyPressed( KeyEvent e )
    {
        // Does nothing.
    }

    // Responds to press of a key; not used, but required by interface.
    public void keyReleased( KeyEvent e )
    {
        // Does nothing.
    }

}