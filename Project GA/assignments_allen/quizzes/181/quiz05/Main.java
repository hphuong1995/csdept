public class Main
{
    public static void main( String[] args )
    {
        int x = 1;
        while ( x < 5 )
        {
            System.out.println( x + 1 );
            x++ ;
        }

        System.out.println();

        int y = 0;
        while ( y <= 10 )
        {
            System.out.println( y );
            y = y + 2;
        }

        System.out.println();

        int z = 20;
        while ( z >= 0 )
        {
            System.out.println( z );
            z-- ;
        }

        System.out.println();

        int v = 1;
        while ( v < 20 )
        {
            System.out.println( v );
            v = v * 2;
        }

        // System.out.println();
        //
        // int w = 10;
        // while ( w > 0 )
        // {
        // System.out.println( w );
        // w = w - ( 1 / 2 );
        // }

        System.out.println();

        System.out.println( "\n------------------------\n" );

        for ( int i = 0; i <= 6; i++ )
        {
            System.out.print( i + ": " );
            if ( i == 0 || i == 6 )
            {
                System.out.println( "OK" );
            }
            else if ( ( i % 2 ) == 0 )
            {
                System.out.println( "THIS" );
            }
            else
            {
                System.out.println( "THAT" );
            }
        }
    }
}
