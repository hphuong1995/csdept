public class Q03
{
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        int base = 2; 
        while( base < 6 ) 
        {
            int pow = base;
            for( int e = 2; e != 4; e++ ) 
            {
                pow = pow * pow;
                System.out.println( pow + ", " + e ); 
            }
            base = base + 3; 
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
