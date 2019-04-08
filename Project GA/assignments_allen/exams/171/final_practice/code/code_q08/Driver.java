import java.awt.Color;

public class Driver
{
    private ColoredOval colored;
    
    public static void main( String[] args )
    {
        Driver d = new Driver();
        d.makeColoredOval();
    }
    
    // creates an Oval, and then changes its color 10 times
    private void makeColoredOval()
    {
        Window window = new Window();
        window.setSize( 500, 500 );
        window.setBackground( Color.white );
        ActionButton button = new ActionButton( this );
        button.setBounds( 200, 450, 100, 30 );
        button.setText( "Change" );
        window.add( button );
        
        colored = new ColoredOval( 200, 200, 100, 100, Color.red );
        window.add( colored );
    }
    
    // responds to button press by changing ColoredOval
    public void handleAction( ActionButton button )
    {
        if ( button.getText().equals( "Change" ) )
        {
            button.setText( "Return" );
            colored.recolor();
        }
        else
        {
            button.setText( "Change" );
            colored.backToOriginal();
        }
        
        Color original = colored.getOriginalColor();
        System.out.println( "Oval color is now: " + colored.getBackground() );
        System.out.println( "Original color was: " + original );
    }
    
}