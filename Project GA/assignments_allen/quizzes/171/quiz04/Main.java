public class Main
{
    public static void main( String[] args )
    {
        int x = 5;
        int y = 10;
        
        if ( x < ( y / 2 ) )
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
        
        x = 10;
        y = 21;
        double z = 10.0;
        
        if ( x >= z )
        {
            y = y / 2;
            if ( y > z )
                z = z / 2;
            else
                z = z * 2;
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
        
        if ( a < 5 || b < 5 )
        {
        	System.out.println( "either a or b is less than 5." );
        }
        
        if ( a == b - 1 || a == b + 1 )
        {
        	System.out.println( "a and b are 1 apart." );
        }
        
        if ( a > 5 && a > b ) 
        {
        	System.out.println( "a is greater than both 5 and b." );
        }
        
        if ( a > 5 )
        {
        	if ( a > b )
        	{
        		System.out.println( "a is greater than both 5 and b." );
        	}
        }
        
    }
}
