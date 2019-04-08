public class Q5
{
    public static void main( String[] args )
    {
        Q5 m = new Q5();
        String str1 = "Hello!!";
        System.out.println( str1 + " -> " + m.countLetters( str1 ) );
        String str2 = m.reverse( str1 );
        System.out.println( str2 + " -> " + m.countLetters( str2 ) );
        System.out.println( m.shuffle( "aaaaa", "BBBBB" ) );
        System.out.println( m.shuffle( "start", "END" ) );
        System.out.println( m.shuffle( "END", "start" ) );
    }
    
    public String reverse( String s )
    {
        String out = new String();
        for ( int i = 0; i < s.length(); i++ )
            out = s.charAt( i ) + out;
        return out;
    }
    
    public int countLetters( String s )
    {
        int num = 0;
        String s2 = s.toLowerCase();
        for ( int i = 0; i < s2.length(); i++ )
        {
            char c = s2.charAt(i);
            
            if ( c >= 'a' && c <= 'z' )
                num++;
                
            // if we don't turn to lower-case first, then do this:
            // if ( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) )
            //     num++;
        }
        return num;
    }
    
    public String shuffle( String s1, String s2 )
    {
        if ( s1.length() != s2.length() )
            return "NO SHUFFLE POSSIBLE";
        
        String out = new String();  
        for ( int i = 0; i < s1.length(); i++ )
            out = out + s1.charAt( i ) + s2.charAt( i );
        
        return out;
    }
}