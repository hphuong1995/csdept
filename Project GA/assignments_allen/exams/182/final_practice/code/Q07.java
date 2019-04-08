public class Q07
{
    public static void main( String[] args )
    {
        Q07 q7 = new Q07();
        String test = q7.concatenate( "Tes", "t is a Test" );
        System.out.println( test );

        System.out.println( q7.remove( test, 't' ) );
        System.out.println( q7.remove( test, 'T' ) );
        System.out.println( q7.remove( test, 'x' ) );
    }

    public String concatenate( String str1, String str2 )
    {
        String concat = str1 + str2;
        return concat;
    }

    public String remove( String str, char c )
    {
        String rem = "";
        for ( int i = 0; i < str.length(); i++ )
        {
            char current = str.charAt( i );
            if ( current != c )
                rem = rem + current;
        }
        return rem;
    }
}