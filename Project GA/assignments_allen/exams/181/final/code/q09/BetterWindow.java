/**
 * An improved Window class.
 *
 * @author M. Allen
 */

public class BetterWindow extends Window
{
    public BetterWindow( String title )
    {
        super( title.toUpperCase() );
        setSize( 250, 250 );
    }
}
