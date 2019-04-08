
/**
 * A simple JFrame-using class to create a window
 * to display graphical JComponent objects.
 *
 * @author M. Allen
 */

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;

public class Window
{
    private JFrame window;
    
    /**
     * post: JFrame created with title == "Window"
     * and x = 50 and y == 50
     * and width == 100 and height == 100
     * and layout == null
     * and background == Color.white
     * and visible == true
     * and resizable == false
     */
    public Window( String title )
    {
        window = new JFrame( title );
        window.setBounds( 50, 50, 100, 100 );
        window.setSize( 100, 100 );
        window.setLayout( null );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.getContentPane().setBackground( Color.white );
        window.setResizable( false );
        window.setVisible( true );
    }
    
    /**
     * post: width == w and height = h
     * (minimum size == 200 and maximum size == 800)
     */
    public void setSize( int w, int h )
    {
        w = Math.max( w, 200 );
        w = Math.min( w, 800 );
        h = Math.max( h, 200 );
        h = Math.min( h, 800 );
        window.setSize( w + window.getInsets().left +
                       window.getInsets().right,
                       h + window.getInsets().top + window.getInsets().bottom );
    }
    
    /**
     * post: x-coordinate == x and y-coordinate = y
     * (minimum size == 200 and maximum size == 800)
     */
    public void setLocation( int x, int y )
    {
        window.setLocation( x, y );
    }
    
    /**
     * post: window title == title
     */
    public void setTitle( String title )
    {
        window.setTitle( title );
    }
    
    /**
     * post: window background == col
     */
    public void setBackground( Color col )
    {
        window.getContentPane().setBackground( col );
        window.repaint();
    }
    
    /**
     * post: adds input any graphical JComponent, like a Triangle
     * or Oval, to JFrame
     */
    public void add( JComponent component )
    {
        window.add( component, 0 );
        component.repaint();
    }
    
    /**
     * post: request for window.repaint() to update graphics
     */
    public void repaint()
    {
        window.repaint();
    }
}
