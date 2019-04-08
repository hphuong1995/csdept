public class Q05
{
    
    public Q05()
    {
        int[][] nums = { { -1, 2, 3 }, { 2, -4, 3, 1 }, { -3, -4 } };
        int[] out = sumPositive( nums );
        for ( int i : out )
            System.out.print( i + " " );
        System.out.println();
    }
    
    private int[] sumPositive( int[][] nums )
    {
        int[] out = new int[nums.length];
        
        for ( int r = 0; r < nums.length; r++ )
            for ( int c = 0; c < nums[r].length; c++ )
                if ( nums[r][c] > 0 )
                    out[r] += nums[r][c];
        
        return out;
    }
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Q05 q5 = new Q05();
    }
    
}
