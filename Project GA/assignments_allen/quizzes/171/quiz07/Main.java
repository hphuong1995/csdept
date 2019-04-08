public class Main
{
    public static void main( String[] args )
    {
        Main m = new Main();
        int b1 = m.aba( 9, 4 );
        int b2 = m.aba( 9, 5 );
        int b3 = m.aba( 10, 4 );
        
        System.out.println( b1 );
        System.out.println( b2 );
        System.out.println( b3 ); 
        
        
        System.out.println( m.test( -5 ) );  
        System.out.println( m.test( -1 ) );  
        System.out.println( m.test( 0 ) );
        System.out.println( m.test( 1 ) );
        System.out.println( m.test( 25 ) );  
    }

    private int aba( int i, int j )
    {
        int a = i / 2;
        return j - a;
    }
    
    private boolean test( int i )
    {
    	return ( i >= 0 ) && ( i % 5 == 0 );
    }
}