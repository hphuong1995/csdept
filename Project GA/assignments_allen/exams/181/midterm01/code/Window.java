/**
 * Author: M. Allen
 * 
 * A simple JFrame-using class to create a window to display Triangle objects
 */
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;

public class Window
{
    private JFrame window;

    /**
     * post: JFrame created with ( getTitle() == "Window" ) && ( getX() == 50 )
     * && ( getY() == 50 ) && ( getWidth() == 200 ) && ( getHeight() == 100 ) &&
     * ( getLayout() == null ) && ( getBackground() == Color.white ) &&
     * isVisible() && !isResizable()
     */
    public Window()
    {
	window = new JFrame( "Window" );
	window.setLocation( 50, 50 );
	window.setSize( 200, 100 );
	window.setLayout( null );
	window.getContentPane().setBackground( Color.white );
	window.setResizable( false );
	window.setVisible( true );
    }

    /**
     * post: window.getX() == x and window.getY() == y
     */
    public void setLocation( int x, int y )
    {
	window.setLocation( x, y );
    }

    /**
     * @return getX() for generated JFrame
     */
    public int getX()
    {
	return window.getX();
    }

    /**
     * @return getX() for generated JFrame
     */
    public int getY()
    {
	return window.getY();
    }

    /**
     * post: ( window.getContentPane().getWidth() == w ) (minimum width == 200
     * and maximum width == 600) && ( window.getContentPane().getHeight() == h )
     * (minimum height == 100 and maximum height == 600)
     */
    public void setSize( int w, int h )
    {
	w = Math.max( w, 200 );
	w = Math.min( w, 600 );
	h = Math.max( h, 100 );
	h = Math.min( h, 600 );
	window.setSize( w + window.getInsets().left + window.getInsets().right,
			h + window.getInsets().top + window.getInsets().bottom );
    }

    /**
     * post: window.getTitle() == title
     */
    public void setTitle( String title )
    {
	window.setTitle( title );
    }

    /**
     * post: window.getBackground() == col
     */
    public void setBackground( Color col )
    {
	window.getContentPane().setBackground( col );
	window.repaint();
    }

    /**
     * post: adds input any graphical JComponent, like a Triangle or Oval, to
     * JFrame
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
