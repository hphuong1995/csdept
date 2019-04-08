public class ArrayWorker
{
    int[] nums;
    
    // post:  saves reference to input array
    public ArrayWorker( int[] array )
    {
        nums = array;
    }
    
    // prints out the array on a single line,
    // with [...] around elements
    public void printArray()
    {
        System.out.print(  "[ " );
        for ( int i = 0; i < nums.length; i++ )
            System.out.print( nums[i] + " " );
        System.out.println( "]" );
    }
    
    // returns:  largest value in array (0) if empty
    public int getLargest()
    {
        if ( nums.length == 0 )
            return 0;
        
        int large = nums[0];
        for ( int i = 1; i < nums.length; i++ )
            if ( nums[i] > large )
                large = nums[i];
        
        return large;
    }
    
}
