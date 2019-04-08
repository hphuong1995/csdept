/**
 * DrawingGizmo is like a drawing pen that
 * can be moved around a drawing canvas
 * This is similar to a turtle from the
 * LOGO programming language.
 * 
 * Class Invariant
 * window is instantiated with a canvas of 260 by 160 colored
 * and the window is colored as established by setBackground
 * and (locX, locY) maintains the position of the drawing tool
 * within the window canvas
 * and direction indicates the direction of travel (in degrees)
 * (increasing the direction value rotates clockwise)
 * 
 * @author Dave Riley
 * @author M. Allen
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings( "serial" )
public class DrawingGizmo extends JComponent
{
    private static JFrame window;
    private int locX, locY;
    private boolean isDrawing;
    private int direction;
    private Robot delayTimer;

    /**
     * post: window@pre != null implies window == window@pre
     * and window.getContentPane().getWidth() == 400 and
     * window.getContentPane().getHeight() == 400
     * and getX() == 200 and getY() == 200 and getWidth() == getHeight() == 9
     * and isDrawing
     * and direction == -90 (the triangle points up)
     */
    public DrawingGizmo()
    {
	super();
	if ( window == null )
	{
	    window = new JFrame( "Drawing Canvas" );
	    window.getContentPane().setLayout( null );
	    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    window.setVisible( true );
	    window.setBounds( 50, 50,
		    400 + window.getInsets().left + window.getInsets().right,
		    400 + window.getInsets().top + window.getInsets().bottom );
	}
	locX = 200;
	locY = 200;
	setBounds( locX, locY, 9, 9 );
	draw();
	direction = -90;
	window.getContentPane().add( this );
	repaint();
	window.repaint();
	try
	{
	    delayTimer = new Robot();
	}
	catch ( Exception e )
	{
	    System.out
		    .println( "This System does not support java.awt.Robot usage." );
	}
    }

    /**
     * post: isDrawing
     */
    public void draw()
    {
	isDrawing = true;
    }

    /**
     * post: !isDrawing
     */
    public void dontDraw()
    {
	isDrawing = false;
	repaint();
    }

    /**
     * post: direction == direction@pre + d (direction rotates clockwise by d
     * degrees)
     */
    public void turnBy( int d )
    {
	direction = direction + d;
	repaint();
    }

    /**
     * post: direction == direction@pre + 30 (direction rotates clockwise by 10
     * degrees)
     */
    public void turnClockwise()
    {
	turnBy( 30 );
    }

    /**
     * post: direction == direction@pre - 30 (direction rotates counterclockwise
     * by 10 degrees)
     */
    public void turnCounterclockwise()
    {
	turnBy( -30 );
    }

    /**
     * post: (locX, locY) is a point at angle direction and d units from
     * (locX@pre, locY@pre)
     * and isDrawing implies a line segment is drawn connecting (locX@pre,
     * locY@pre)
     * with (locX, locY)
     */
    public void moveBy( int d )
    {
	Line line;
	int oldX = locX;
	int oldY = locY;
	locX = oldX + (int) ( d * Math.cos( Math.toRadians( direction ) ) );
	locY = oldY + (int) ( d * Math.sin( Math.toRadians( direction ) ) );
	setLocation( locX, locY );
	if ( isDrawing )
	{
	    line = new Line( oldX + 4, oldY + 4, locX + 4, locY + 4 );
	    line.setForeground( getForeground() );
	    window.getContentPane().add( line );
	    line.repaint();
	}
	repaint();
    }

    /**
     * post: (locX, locY) is a point at angle direction and 20 units from
     * (locX@pre, locY@pre)
     * and isDrawing implies a line segment is drawn connecting (locX@pre,
     * locY@pre)
     * with (locX, locY)
     */
    public void moveForward()
    {
	moveBy( 20 );
    }

    /**
     * post: the window is recolored to match c
     */
    public void setBackground( Color c )
    {
	window.getContentPane().setBackground( c );
    }

    /**
     * post: this is drawn as an arrow at position (locX,locY),
     * angled according to direction
     * and isDrawing implies the arrow is colored green
     * otherwise the arrow is colored red
     */
    public void paint( Graphics g )
    {
	if ( isDrawing )
	    g.setColor( Color.green );
	else
	    g.setColor( Color.red );
	( (Graphics2D) g ).rotate( Math.toRadians( direction ), getWidth() / 2,
	        getHeight() / 2 );
	g.drawLine( 2, 1, 8, 4 );
	g.drawLine( 8, 4, 2, 7 );
	g.drawLine( 0, 4, 8, 4 );
	g.drawLine( 6, 3, 6, 5 );
	g.drawLine( 5, 3, 5, 5 );
	g.drawLine( 4, 2, 4, 6 );
	g.drawLine( 3, 2, 3, 6 );
    }

    /**
     * post: all activity delayed by 2000 ms (2 seconds)
     */
    public void delay2Sec()
    {
	delayTimer.delay( 2000 );
    }

    /**
     * post: all activity delayed by t ms
     */
    public void delayBy( int t )
    {
	delayTimer.delay( t );
    }

    /**
     * This internal class is used to construct line segments for the drawing
     * tool.
     */
    private class Line extends JComponent
    {
	private boolean isMajorDiagonal;

	public Line( int x1, int y1, int x2, int y2 )
	{
	    super();
	    setBounds( Math.min( x1, x2 ), Math.min( y1, y2 ),
		    Math.abs( x1 - x2 ) + 1, Math.abs( y1 - y2 ) + 1 );
	    isMajorDiagonal = ( x1 == Math.min( x1, x2 ) && y1 == Math.min( y1,
		    y2 ) )
		              ||
		              ( x2 == Math.min( x1, x2 ) && y2 == Math.min( y1,
		                      y2 ) );
	}

	/**
	 * post: DrawingGizmo and associated lines drawn to screen
	 */
	public void paint( Graphics g )
	{
	    g.setColor( getForeground() );
	    if ( isMajorDiagonal )
		g.drawLine( 0, 0, getWidth() - 1, getHeight() - 1 );
	    else
		g.drawLine( 0, getHeight() - 1, getWidth() - 1, 0 );
	}
    }
}