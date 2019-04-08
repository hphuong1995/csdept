public class Driver
{
    public static void main( String[] args )
    {
        Driver d = new Driver();
        String s = "Pork tacos";
        String noVowels = d.removeVowels( s );
        String longest = d.getLongest( s, noVowels );
        String swap = d.swapChars( 'o', 'e', s );
        System.out.println( "Starting string = " + s );
        System.out.println( "String without vowels = " + noVowels );
        System.out.println( "Longest string = " + longest );
        System.out.println( "Swapped string = " + swap );
    }
    
    // method to return String without vowels
    private String removeVowels( String s )
    {
        String out = new String();
        for ( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt( i );
            if ( c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' )
                out = out + c;
        }
        return out;
    }
    
    // method to return longest of two Strings
    private String getLongest( String s1, String s2 )
    {
        if ( s1.length() >= s2.length() )
            return s1;
        else
            return s2;
    }
    
    // method to swap characters in a String
    private String swapChars( char c1, char c2, String s )
    {
        String out = new String();
        for ( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt( i );
            if ( c == c1 )
                out = out + c2;
            else
                out = out + c;
        }
        return out;
    }
}
