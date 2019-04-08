public class Q5
{
    public static void main( String[] args )
    {
        Q5 q5 = new Q5();
        String str1 = "Everyone";
        System.out.println( str1 + " " + q5.countVowels( str1 ) );
        String str2 = q5.reverse( str1 );
        System.out.println( str2 + " " + q5.countVowels( str2 ) );
        System.out.println( q5.shuffle( "word", "WORD" ) );
        System.out.println( q5.shuffle( str1, str2 ) );
        System.out.println( q5.shuffle( "start", "END" ) );
        System.out.println( q5.shuffle( "END", "start" ) );
    }
        
    /* Counts vowels (a, e, i, o, u), upper/lower case in String. */
    private int countVowels( String s )
    {
        int num = 0;
        String s2 = s.toLowerCase();
        for ( int i = 0; i < s2.length(); i++ )
        {
            char c = s2.charAt(i);
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
            {
                num++;
            }
        }
        return num;
    }
    
    /* Returns reverse of a String. */
    private String reverse( String s )
    {
        String out = new String();
        for ( int i = 0; i < s.length(); i++ )
        {
            out = s.charAt( i ) + out;
        }
        return out;
    }
    
    /* Returns a shuffle of characters from two Strings; must be of same length. */
    private String shuffle( String s1, String s2 )
    {
        if ( s1.length() != s2.length() )
        {
            return "NO SHUFFLE POSSIBLE";
        }
        
        String out = new String();  
        for ( int i = 0; i < s1.length(); i++ )
        {
            out = out + s1.charAt( i ) + s2.charAt( i );
        }
        return out;
    }
}