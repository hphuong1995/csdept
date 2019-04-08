/**
 * Answer to question 5, CS 120 Midterm 02 (Spring 2017).
 * 
 * @author M. Allen
 */

public class Q5
{

    public static void main( String[] args )
    {
        Q5 q5 = new Q5();
        System.out.println( "Vowels in Everyone: " + q5.countVowels( "Everyone" ) );
        System.out.println( "Vowels in Fzplxzyz: " + q5.countVowels( "Fzplxzyz" ) );
        System.out.println( "#a in Dark Aardvarks: " + q5.countChar( "Dark Aardvarks", 'a' ) );
        System.out.println( "#q in Banana Hammers: " + q5.countChar( "Banana Hammers", 'q' ) );
        System.out.println( "Banana Hammers - a: " + q5.removeChar( "Banana Hammers", 'a' ) );
        System.out.println( "hamhamhamhamham - m: " + q5.removeChar( "hamhamhamhamham", 'm' ) );

    }

    private int countVowels( String s )
    {
        String lower = s.toLowerCase();
        int count = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            char c = lower.charAt( i );
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
            {
                count++ ;
            }
        }
        return count;
    }

    private int countChar( String s, char c )
    {
        int occur = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( s.charAt( i ) == c )
            {
                occur++ ;
            }
        }
        return occur;
    }

    private String removeChar( String s, char c )
    {
        String rest = new String();
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( s.charAt( i ) != c )
            {
                rest = rest + s.charAt( i );
            }
        }
        return rest;
    }

}
