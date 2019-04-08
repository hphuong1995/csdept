public class Q01
{    
    public static void main( String[] args )
    {
        Q01 q01 = new Q01();
        q01.testHasNegative();
    }
    
    private void testHasNegative()
    {
        int[] input = { 5, 2, -3, 4, 5 };
        boolean neg = hasNegative( input );
        System.out.println( "Array has negative values: " + neg );
     
        input = new int[0];  // empty array
        neg = hasNegative( input );
        System.out.println( "Array has negative values: " + neg );        
    }
    
    private boolean hasNegative( int[] in )
    {
        for ( int i = 0; i < in.length; i++ )
        {
            if ( in[i] < 0 )
            {
                return true;
            }
        }
        return false;
    }
 }
