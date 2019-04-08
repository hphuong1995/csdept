/****************
 * Name:  M. Allen
 *
 * Generate a shape in a window at random.
 ****************/

import java.awt.Color;

public class Q6
{
    public static void main( String[] args )
    {
        Window win = new Window();
        int winSize = 300;
        win.setSize( winSize, winSize );
        
        int val1 = (int)( Math.random() * 2 ) + 1;
        int val2 = (int)( Math.random() * 2 ) + 1;
		
		int shapeSize = 50;
		int shapeLoc = ( winSize / 2 ) - ( shapeSize / 2 ); 
		if ( val1 < val2 )
		{
			Oval o = new Oval( shapeLoc, shapeLoc, shapeSize, shapeSize );
			win.add( o );
		}
		else if ( val1 > val2 )
		{
			Rectangle r = new Rectangle( shapeLoc, shapeLoc, shapeSize, shapeSize );
			win.add( r );
		}
		else
			win.setBackground( Color.black );
    }
}
