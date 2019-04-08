public class Main
{
    public static void main( String[] args )
    {
        Main m = new Main();
        int b1 = m.aba( 9, 6 );
        int b2 = m.aba( 6, 9 );
        int b3 = m.aba( 10, 6 );
        
        System.out.println( " 9, 6: " + b1 );
        System.out.println( " 6, 9: " + b2 );
        System.out.println( "10, 6: " + b3 ); 
        
        
        System.out.println( " 0: " + m.test( 0 ) );  
        System.out.println( "10: " + m.test( 10 ) );  
        System.out.println( "11: " + m.test( 11 ) );
        System.out.println( "44: " + m.test( 44 ) );
    }

    private int aba( int x, int y )
    {
        int div = x / 3;
        return y - div;
    }

    
    private boolean test( int i )
    {
    	return ( i > 10 ) && ( i % 2 == 0 );
    }
}