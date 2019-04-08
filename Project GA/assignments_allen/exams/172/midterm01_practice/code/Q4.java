import java.awt.Color;
import java.util.*;

public class Q4
{
	public static void main( String[] args ) 
	{
		Oval o1, o2, o3, o4;
		o1 = new Oval( 50, 50, 100, 100 );
		o2 = new Oval( 100, 100, 200, 200 );
		o3 = null;
		o4 = new Oval( 200, 200, 300, 300 );
		
		o1 = o2;
		o2 = o3;
		o3 = o4;
		o4 = o1;
		
		o1.setBackground( Color.blue );
		//o2.setBackground( Color.red );
		o3.setBackground( Color.green );
		o4.setBackground( Color.magenta );
		
		System.out.println( o1.getBackground() );
		//System.out.println( o2.getBackground() );
		System.out.println( o3.getBackground() );
		System.out.println( o4.getBackground() );
	}
}