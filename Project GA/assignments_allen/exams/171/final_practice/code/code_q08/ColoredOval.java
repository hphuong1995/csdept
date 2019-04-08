import java.awt.Color;

public class ColoredOval extends Oval
{
    private Color originalColor;
    
    public ColoredOval( int x, int y, int w, int h, Color c )
    {
        super( x, y, w, h );
        originalColor = c;
        super.setBackground( originalColor );
    }
    
    public void recolor()
    {
        int num = (int)( Math.random() * 2 );
        if ( num == 0 )
        {
            super.setBackground( Color.blue );
        }
        else
        {
            super.setBackground( Color.green );
        }
    }
    
    public void backToOriginal()
    {
        super.setBackground( originalColor );
    }
    
    public Color getOriginalColor()
    {
        return originalColor;
    }
       
    public void setBackground( Color c )
    {
    	// does nothing
    }
}