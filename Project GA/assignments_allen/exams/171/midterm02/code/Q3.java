public class Q3
{
    public static void main( String[] args )
    {
        Q3 q = new Q3();
        System.out.println( q.process( "Dogs", "Doges" ) + "." );
        System.out.println( q.process( "Doges", "Dogs" ) + "." );
        System.out.println( q.process( "", "Hello" ) + "." );
        
        System.out.println("\n");
        q.printNums( 4, 4 );
    }
    
    private boolean process( String s1, String s2 )
    {
        for ( int i = 0; i < s1.length(); i++ )
        {
            boolean b = false;
            for ( int j = 0; j < s2.length(); j++ )
            {
                if ( s1.charAt( i ) == s2.charAt( j ) )
                {
                    b = true;
                }
            }
            if ( !b )
            {
                return false;
            }
        }
        return true;
    }  
      
    private void printNums( int num1, int num2 )
    {
        for ( int i = 1; i <= num1; i++ )
        {
            System.out.print( i + "." );
            for ( int j = 1; j <= num2; j++ )
            {
                int d = i / j;
                System.out.print( " " + d );
            }
            System.out.println();
        }
    }
}