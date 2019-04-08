/**
 * Author: M. Allen
 * 
 * An extension to JButton that binds the button action to a Driver object.
 * Driver must implement public void handleAction().
 */
import java.awt.event.*;
import javax.swing.JButton;

@SuppressWarnings( "serial" )
public class ActionButton extends JButton implements ActionListener
{
    /* Driver to tell about any action events. */
    private Driver driver;

    
    /**
     * @param d : a Driver for communication.
     * 
     * pre: d must be properly initialized; must possess handleAction() method.
     * 
     * post: text == driver variable instantiated.
     */
    public ActionButton( Driver d )
    {
	super();
	driver = d;
	addActionListener( this );
    }

    /**
     * @param e : ActionEvent from associated objects
     * 
     * post: this sent to driver.handleAction()
     */
    public void actionPerformed( ActionEvent e )
    {
	driver.handleAction( this );
    }
}
