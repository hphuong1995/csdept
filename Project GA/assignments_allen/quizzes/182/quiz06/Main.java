public class Main
{
    public static void main( String[] args )
    {
        for ( int i = 1; i < 5; i++ )
        {
            System.out.print( i + ":" );
            for ( int j = i; j >= 0; j-- )
            {
                System.out.print( " " + j );
            }
            System.out.println();
        }
        
        System.out.println( "\n-------------------\n" );
        
        for ( int i = 5; i >= 1; i-- )
        {
            for ( int j = 1; j <= i; j++ )
            {
                System.out.print( j + " " );    
            }
            System.out.println();
        }
        
        
        System.out.println( "\n-------------------\n" );
        
        Main m = new Main();
        m.loop ( 4 );
        System.out.println();
        m.loop2( 5, 3, 2 );
        System.out.println();
        m.loop2( 2, 2, 1 );
        System.out.println();
        m.loop2( 5, 2, 3 );
        System.out.println();
        m.loop2( 100, 1, 0 );

    }
    
    
    public void loop( int num )
    {
       for ( int i = num; i >= 0; i-- )
       {
             System.out.print( i + " " );
       }
    }
    
    public void loop2( int num1, int num2, int num3 )
    {
        for ( int i = 0; i < num3; i++ )
        {
            for ( int j = num1; j >= num2; j-- )
            {
                System.out.print( j + " " );
            }
            System.out.println();
        }
    }
}