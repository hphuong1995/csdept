/**
 * Author: David Riley & M. Allen
 *
 * Creates a simple graphical oval.
 */
import javax.swing.*;
import java.awt.*;

@SuppressWarnings( "serial" )
public class Oval extends JComponent
{
    /** post:   getX() == x  and  getY() == y
     *          and  getWidth() == w  and getHeight() == h
     *          and  getBackground() == Color.black
     */
    public Oval( int x, int y, int w, int h )
    {
        super();
        setBounds( x, y, w, h );
        setBackground( Color.black );
    }
    
    /**
     * @param comp : JComponent to test for intersection
     * @return : true iff this intersects comp
     */
    public boolean intersects( JComponent comp )
    {
        java.awt.Rectangle r1, r2;
        r1 = this.getBounds( null );
        r2 = comp.getBounds( null );
        return r1.intersects( r2 );
    }
    
    /**
     *  post:   Draws a filled Oval
     *          and  the upper left corner of the bounding rectangle is ( getX(), getY() )
     *          and  the oval's dimensions are getWidth() and getHeight()
     *          and  the oval's color is getBackground()
     */
    public void paint( Graphics g )
    {
        g.setColor( getBackground() );
        g.fillOval( 0, 0, getWidth(), getHeight() );
        paintChildren( g );
    }
}