public class Main
{
    
    public static void main( String[] args )
    {
        Main m = new Main();
        System.out.println( "\nQuestion 01:\n" );
        
        int[] input = { 5, 2, -3, 4, 5 };
        boolean neg = m.hasNegative( input );
        System.out.println( "Array has negative values: " + neg );
        input = new int[0];  // empty array
        neg = m.hasNegative( input );
        System.out.println( "Array has negative values: " + neg );
        
        System.out.println( "\nQuestion 02:\n" );
        
        int[][] ints = m.fillArray();
        for ( int row = 0; row < ints.length; row++ )
        {
            for ( int col = 0; col < ints[row].length; col++ )
                System.out.printf( "%2d ", ints[row][col] );
            
            System.out.println();
        }
    }
    
    private boolean hasNegative( int[] in )
    {
        for ( int i = 0; i < in.length; i++ )
            if ( in[i] < 0 )
                return true;
        
        return false;
    }
    
    private int[][] fillArray()
    {
        int[][] nums = new int[5][10];
        
        for ( int row = 0; row < nums.length; row++ )
            for ( int col = 0; col < nums[row].length; col++ )
                nums[row][col] = ( row + 1 ) * ( col + 1 );
        
        return nums;
    }
    
}
