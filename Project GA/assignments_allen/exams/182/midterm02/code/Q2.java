public class Q2
{
    public static void main( String[] args )
    {
        int num = 10;
        while ( num > 0 )
        {
            System.out.println( num );
            num = num - 2;
        }
        
        System.out.println( "-----------" );
        for ( int i = 1; i <= 32; i = i * 2 )
        {
            System.out.println( i );
        }
    }
}