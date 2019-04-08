public class ArrayWorker
{
    private int[] nums;
    
    // Saves reference to input array.
    public ArrayWorker( int[] array )
    {
        nums = array;
    }
    
    // Sums and prints array elements.
    public void sumAndPrint()
    {
        System.out.print( "Sum of [ " );
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            sum += nums[i];
            System.out.print( nums[i] + " " );
        }
        System.out.println( "] = " + sum );
    }
}
