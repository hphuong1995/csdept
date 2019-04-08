public class Q5
{
    public static void main( String[] args )
    {
        Q5 q = new Q5();
        char ch = q.getChar( "Test", -11 );
        System.out.print( ch + " " );
        ch = q.getChar( "Test", 2 );
        System.out.print( ch + " " );
        ch = q.getChar( "", 0 );
        System.out.println( ch );
        int i = q.countChar( "this is a test", 't' );
        System.out.print( i + " " );
        i = q.countChar( "THIS IS A TEST", 't' );
        System.out.println( i );
        String s = q.removeAll( "this is a test", ' ' );
        System.out.println( s );
        s = q.removeAll( s, 's' );
        System.out.println( s );
    }
    
    private char getChar( String s, int pos )
    {
        if ( pos < 0 || pos >= s.length() )
        {
            return '.';
        }
        return s.charAt( pos );
    }
    
    private int countChar( String s, char c )
    {
        int num = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( s.charAt( i ) == c )
            {
                num++ ;
            }
        }
        return num;
    }
    
    private String removeAll( String s, char c )
    {
        String out = "";
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( s.charAt( i ) != c )
            {
                out = out + s.charAt( i );
            }
        }
        return out;
    }
}
