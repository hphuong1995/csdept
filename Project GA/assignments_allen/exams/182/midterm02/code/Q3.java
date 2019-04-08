public class Q3
{
    public static void main( String[] args )
    {
        Q3 q = new Q3();
        System.out.println( q.process( "Dogs", "Doges" ) + "." );
        System.out.println( q.process( "Doges", "Dogs" ) + "." );
        System.out.println( q.process( "Dogs", "Dogs" ) + "." );
        System.out.println( q.process( "Apple", "APPLE" ) + "." );
        System.out.println( q.process( "", "Hello" ) + "." );
        
        System.out.println("\n");
        q.printNums( 3, 2.0 );
    }
    
    private String process( String s1, String s2 )
    {
        int len = s1.length();
        if ( s2.length() < len ) {
            len = s2.length();
        }
        
        String out = new String();
        for ( int i = 0; i < len; i++ ) {
            if ( s1.charAt( i ) != s2.charAt( i ) ) {
                out = out + s2.charAt( i );
            }
        }
        return out;
    }
    
    private void printNums( int num1, double num2 )
    {
        for ( int i = 1; i <= num1; i++ ) {
            System.out.print( i + ": " );
            for ( int j = 0; j <= i; j++ ) {
                double val = j * num2;
                System.out.print( val + ", " );
            }
            System.out.println( ( i + 1 ) * num2 );
        }
    }
}