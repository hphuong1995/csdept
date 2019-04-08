public class Q03
{
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        int base = 2; 
        while( base <= 4 ) 
        {
            int pow = base;
            for( int i = 1; i <= 3; i++ ) 
            {
                pow = pow * pow;
                System.out.println( i + ": " + pow ); 
            }
            base = base + 2; 
        }
        
        System.out.println( "\n--------------------------\n" );
           
                
        int[] arr = { 5, 2, 1, 6 };
        int[] sums = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ )
        {
            int s = 0;
            for ( int j = 0; j < arr.length; j++ )
            {
                if ( arr[j] >= arr[i] )
                {
                    s = s + arr[j];
                }
            }
            sums[i] = s;
            System.out.println( arr[i] + ": " + sums[i] );
        }
           
    }
    
}
