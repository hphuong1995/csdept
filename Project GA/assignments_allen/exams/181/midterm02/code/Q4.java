public class Q4
{
    public static void main( String[] args )
    {
        for ( int i = 1; i <= 10; i++ )
        {
            if ( i < 10 )
            {
                System.out.print( " " );
            }
            System.out.print( i + " = " );
            
            for ( int j = 1; j <= i; j++ )
            {
                if ( ( i * j ) < 10 )
                {
                    System.out.print( " " );
                }
                System.out.print( " " + ( i * j ) + "/" + j );
            }
            System.out.println();
        }
    }
}
