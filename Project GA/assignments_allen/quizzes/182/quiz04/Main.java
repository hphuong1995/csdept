public class Main
{
    public static void main( String[] args )
    {
        int x = 5;
        int y = 11;
        
        if ( ( y / 2 ) > x )
        {
            y = x;
            x = y;
        }
        else if ( y != x )
        {
            x = y;
            y = x;
        }
        
        System.out.println( "x = " + x + ", y = " + y );
        
        x = 3;
        y = 10;
        double z = 3.0;
        
        if ( x == z )
        {
            y = y / 3;
            if ( y > z )
            {
                z = z / 2;
            }
            else
            {
                z = z * 2;
            }
        }
        else
        {
            z = x;
            x = y;
            y = (int) z;
        }
        
        System.out.println( "x = " + x + ", y = " + y + ", z = " + z );
        
        int a = (int)( Math.random() * 10 + 1 );
        int b = (int)( Math.random() * 10 + 1 );
        System.out.printf( "a = %d, b = %d\n", a, b );
        
        if ( a > 5 && b <= 5 )
        {
        	System.out.println( "a is greater than 5, but b isn't." );
        }
        
        if ( a < 4 || b < 4 )
        {
        	System.out.println( "Either a or b is less than 4." );
        }
        
        if ( a - 1 <= b && b <= a + 1 )
        {
        	System.out.println( "b is within 1 of a." );
        }
        
        if ( a > 5 && b > a ) 
        {
        	System.out.println( "a is greater than 5, and b is greater than a." );
        }
        
        if ( a > 5 )
        {
        	if ( b > a )
        	{
            	System.out.println( "a is greater than 5, and b is greater than a." );
        	}
        }
        
    }
}
