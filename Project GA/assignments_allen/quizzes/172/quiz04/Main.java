public class Main
{
    public static void main( String[] args )
    {
        int x = 3;
        int y = 7;
        
        if ( x >= ( y / 2 ) )
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
        
        x = 5;
        y = 10;
        double z = 5.0;
        
        if ( x <= z )
        {
            y = y / 2;
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
        
        if ( a < 3 && b >= 3 )
        {
        	System.out.println( "a is less than 3, but b isn't." );
        }
        
        if ( a > 7 || b > 7 )
        {
        	System.out.println( "either a or b is greater than 7." );
        }
        
        if ( a >= b - 2 && a <= b + 2 )
        {
        	System.out.println( "a is within 2 of b." );
        }
        
        if ( a > b && b > 3 ) 
        {
        	System.out.println( "a is greater than b, and b is greater than 3." );
        }
        
        if ( a > b )
        {
        	if ( b > 3 )
        	{
            	System.out.println( "a is greater than b, and b is greater than 3." );
        	}
        }
        
    }
}
