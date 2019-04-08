public class Q2
{
    public static void main( String[] args )
    {
        int num = 10;
        int count = 1;
        while ( num >= 0 )
        {
            System.out.printf( "%d: %d\n", count, num );
            num--;
            count++;
        }
        
        // infinite loop!      
/*        System.out.println( "---------" );
        for ( int i = 0; i <= 8; i = i * 2 )
        {
            System.out.println( i );
        }
*/
    }
}