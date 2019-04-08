public class ArrayWorker
{
    private String[] words;
    
    // Saves reference to input array.
    public ArrayWorker( String[] array )
    {
        words = array;
    }
    
    // Sums and prints array elements.
    public void printLongest()
    {
        System.out.print( "Longest String in [ " );
        int longestLength = 0;
        for ( int i = 0; i < words.length; i++ )
        {
            if ( words[i].length() > longestLength )
            {
                longestLength = words[i].length();
            }
            System.out.print( words[i] + " " );
        }
        System.out.println( "]: " + longestLength );
    }
}
