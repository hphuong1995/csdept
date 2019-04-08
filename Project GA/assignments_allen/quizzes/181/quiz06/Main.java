public class Main
{
    public static void main( String[] args )
    {
        for ( int i = 5; i > 0; i-- )
        {
            System.out.print( i + ":" );
            for ( int j = 0; j <= i; j++ )
            {
                System.out.print( " " + j );
            }
            System.out.println();
        }
        
        System.out.println( "\n-------------------\n" );
        
        for ( int i = 0; i < 6; i++ )
        {
            for ( int j = 0; j <= i; j++ )
            {
                System.out.print( j + " " );
            }
            System.out.println();
        }
        
        
        System.out.println( "\n-------------------\n" );
        
        Main m = new Main();
        m.loop ( 4 );
        System.out.println();
        m.loop2( 5, 2 );
        System.out.println();
        m.loop2( 2, 5 );
        System.out.println();
        m.loop2( 2, 2 );
        System.out.println();
        m.loop2(-1, 3);
        System.out.println();
        m.loop2(10, 0);

    }
    
    
    public void loop( int num )
    {
       for ( int i = num; i >= 0; i-- )
       {
             System.out.print( i + " " );
       }
    }
    
    public void loop2( int num1, int num2 )
    {
        for ( int i = num1; i >= 0; i-- )
            for ( int j = 0; j < num2; j++ )
            {
                System.out.print( i + " " );
            }
    }
}