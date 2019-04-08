public class Main
{
    
    public static void main( String[] args )
    {        
        Main m = new Main();
        System.out.println( "\nQuestion 01:\n" );
        
        String[] input = { "This", "is", "a", "test" };
        boolean con = m.contains( input, "test" );
        System.out.println( "Array contains \"test\": " + con );
        input = new String[0];  // empty array
        con = m.contains( input, "test" );
        System.out.println( "Array contains \"test\": " + con );
        
        System.out.println( "\nQuestion 02:\n" );
        
        int[][] ints = m.fillArray();
        for ( int row = 0; row < ints.length; row++ )
        {
            System.out.print( "     " );
            for ( int col = 0; col < ints[row].length; col++ )
                System.out.printf( "%2d ", ints[row][col] );
            
            System.out.println();
        }
    }
    
    private boolean contains( String[] array, String str )
    {
        for ( int i = 0; i < array.length; i++ )
        {
            if ( array[i].equals( str ) )
            {
                return true;
            }
        }
        return false;
    }
    
    private int[][] fillArray()
    {
        int[][] nums = new int[5][10];
        
        for ( int row = 0; row < nums.length; row++ )
        {
            int val = row + 1;
            for ( int col = 0; col < nums[row].length; col++ )
            {
                nums[row][col] = val;
                val--;
            }
        }
        return nums;
    }
    
}
