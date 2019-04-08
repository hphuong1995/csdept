import java.awt.Color;

public class ColoredOval extends Oval
{    
    public ColoredOval( int x, int y, int w, int h, Color c )
    {
        super( x, y, w, h );
        setBackground( c );
    }
}