/**
 * Generate a randomly colored diamond image.
 * (Midterm 01, question 06.)
 *
 * @author M. Allen
 */

import java.awt.Color;

public class Q6
{
    public static void main( String[] args )
    {
        Window win = new Window();
        win.setTitle( "Shine like a diamond" );
        win.setBackground( Color.white );
        int winSize = 200;
        win.setSize( winSize, winSize );
	
		int shapeSize = winSize / 2;
		int x = winSize / 2 - shapeSize / 2;
		Triangle top = new Triangle( x, 0, shapeSize, shapeSize, 1 );
		Triangle bottom = new Triangle( x, winSize / 2, shapeSize, shapeSize, 0 );
        win.add( top );
        win.add( bottom );
        
        int rand = (int)( Math.random() * 3 );
        
        if ( rand == 0 )
        {
        	top.setBackground( Color.blue );
        	bottom.setBackground( Color.blue );
        }
        else if ( rand == 1 )
        {
        	top.setBackground( Color.red );
        	bottom.setBackground( Color.red );
        }
        else
        {
        	top.setBackground( Color.green );
        	bottom.setBackground( Color.green );
        }
    }
}
