public class Q01
{    
    public static void main( String[] args )
    {
        Q01 q01 = new Q01();
        System.out.println( "\nQuestion 01:\n" );
        
        int[] input = { 4, 2, 3, 4, 2 };
        boolean odd = q01.hasOdd( input );
        System.out.println( "Array has at least one odd value: " + odd );
        
        input = new int[0];  // empty array
        odd = q01.hasOdd( input );
        System.out.println( "Array has at least one odd value: " + odd );
    }
    
    private boolean hasOdd( int[] in )
    {
        for ( int i = 0; i < in.length; i++ )
        {
            if ( in[i] % 2 != 0 )
            {
                return true;
            }
        }
        return false;
    }
}
