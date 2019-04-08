import java.awt.Color;
import javax.swing.JFrame;

public class Driver
{
    private ColoredOval colored;

    public static void main( String[] args )
    {
        Driver d = new Driver();
    }

    public Driver()
    {
        JFrame window = new JFrame( "Question 9" );
        window.setBounds( 100, 100, 500, 500 );
        window.setLayout( null );
        window.getContentPane().setBackground( Color.white );
        window.setVisible( true );

        colored = new ColoredOval( 200, 200, 100, 100, Color.red );
        window.add( colored );
    }
}