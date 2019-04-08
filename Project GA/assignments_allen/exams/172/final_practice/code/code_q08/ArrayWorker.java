public class ArrayWorker
{
    private String[] strings;

    /**
     * Class constructor; input array of data is saved for later use.
     */
    public ArrayWorker( String[] words )
    {
        strings = words;
    }

    /**
     * Returns longest String in array; returns empty String if array is empty.
     */
    public String getLongest()
    {
        if ( strings.length == 0 )
        {
            return "";
        }

        String longest = strings[0];
        for ( int i = 1; i < strings.length; i++ )
        {
            if ( strings[i].length() > longest.length() )
            {
                longest = strings[i];
            }
        }
        return longest;
    }

    /**
     * Returns array containing lengths of Strings in original array; returns
     * empty array if original is empty.
     */
    public int[] getLengths()
    {
        int[] lengths = new int[strings.length];
        for ( int i = 0; i < strings.length; i++ )
        {
            lengths[i] = strings[i].length();
        }
        return lengths;
    }
}