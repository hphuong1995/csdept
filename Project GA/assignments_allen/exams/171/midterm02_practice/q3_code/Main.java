public class Main
{
    public static void main( String[] args )
    {
        Main m = new Main();
        m.method1( "Hello" );
        
        System.out.println( "\n------------\n" );
        
        m.method2( 5, 10 );
    }
    
    private void method1( String sin )
    {
        String sout = new String();
        for ( int i = 0; i < sin.length(); i++ )
        {
            sout = sin.charAt( i ) + sout;
            System.out.println( sout );
        }
    }    
    
    private void method2( int num1, int num2 )
    {
        for ( int i = 0; i < num1; i++ )
        {
            System.out.print( i + ": " );
            int j = i;
            while ( j < num2 )
            {
                System.out.print( j + " " );
                j = j + 2;
            }
            System.out.println( "END" );
        }
    }
}
