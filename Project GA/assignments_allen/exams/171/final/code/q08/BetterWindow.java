/**
 * An improved Window class.
 *
 * @author M. Allen
 */
import java.awt.Color;

public class BetterWindow extends Window
{
    public BetterWindow( String title )
    {
        super( title );
        setTitle( title );
        setSize( 250, 250 );
    }
    
    public void setSize( int w, int h )
    {
        if ( w < 250 )
            w = 250;
        if ( w > 500 )
            w = 500;
        if ( h < 250 )
            h = 250;
        if ( h > 500 )
            h = 500;
        
        super.setSize( w, h );
    }
    
    public void setTitle( String title )
    {
        String t = title.substring( 0, 1 );
        t = t.toUpperCase();
        String t2 = title.substring( 1 );
        t = t + t2.toLowerCase();
        super.setTitle( t );
    }
}
