public class Main
{
    public static void main( String[] args )
    {
        Main m = new Main();
        int b1 = m.aba( 10, 8 );
        int b2 = m.aba( 8, 10 );
        int b3 = m.aba( 9, 10 );
        
        System.out.printf( "%2d, %2d: %d\n", 10, 8, b1 );
        System.out.printf( "%2d, %2d: %d\n", 8, 10, b2 );
        System.out.printf( "%2d, %2d: %d\n", 9, 10, b3 );
        
        for ( int i = 0; i <= 12; i++ )
        {
            System.out.printf( "%2d: %b\n", i, m.test( i ) );  
        }
    }

    private int aba( int a, int b )
    {
        int div = a / 2;
        return b + div;
    }

    
    private boolean test( int i )
    {
    	return i > 0 && i <= 10 && i % 2 == 1;
    }
}