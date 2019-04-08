public class Main
{
    public static void main( String[] args )
    {
        int num = 0;
        while ( num < 11 )
        {
            System.out.println( num );
            num = num + 1;
        }
        
        System.out.println("------------");
            
        for ( int i = 0; i <= 10; i += 2 )
            System.out.println( i );
                    
        System.out.println("------------"); 
            
        for ( int j = 0; j < 10; j = j + 3 )
            System.out.println( j );
    }
}