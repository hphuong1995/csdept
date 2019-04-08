
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
        win.setTitle( "Little House" );
        win.setBackground( Color.white );
       
        int winSize = (int) ( Math.random() * 301 + 200 );
        win.setSize( winSize, winSize );

        int shapeSize = winSize / 2;
        // Next calculation can also be: x = ( winSize / 4 );
        int x = ( winSize - shapeSize ) / 2;
        Triangle top = new Triangle( x, 0, shapeSize, shapeSize, 1 );
        Rectangle bottom = new Rectangle( x, winSize / 2, shapeSize, shapeSize );
        win.add( top );
        win.add( bottom );

        int rand = (int) ( Math.random() * 2 );

        if ( rand == 0 )
        {
            top.setBackground( Color.blue );
        }
        else
        {
            top.setBackground( Color.red );
        }

        rand = (int) ( Math.random() * 2 );
        if ( rand == 0 )
        {
            bottom.setBackground( Color.blue );
        }
        else
        {
            bottom.setBackground( Color.red );
        }
    }
}
