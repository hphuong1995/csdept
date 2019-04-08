public class Q07
{
    
    /**
     *
     */
    public Q07()
    {
        String[] cards1 = { "Ace", "King", "Queen", "Jack" };
        String[] cards2 = { "10", "9", "8", "7" };
        String[] cards3 = { "2", "3" };
        
        String[] out1 = shuffle( cards1, cards2 );
        String[] out2 = shuffle( cards1, cards3 );
        
        for ( String s : out1 )
            System.out.print( s + " " );
        System.out.println();
        for ( String s : out2 )
            System.out.print( s + " " );
        System.out.println();
    }
    
    private String[] shuffle( String[] arr1, String[] arr2 )
    {
        if ( arr1.length != arr2.length )
            return new String[0];
        
        String[] out = new String[arr1.length + arr2.length];
        for ( int i = 0; i < arr1.length; i++ )
        {
            out[i * 2] = arr1[i];
            out[i * 2 + 1] = arr2[i];
        }
        
        return out;
    }
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Q07 m = new Q07();
    }
    
}
