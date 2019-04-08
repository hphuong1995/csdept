public class Q06
{
    public static void main( String[] args )
    {
        Q06 q7 = new Q06();
        String mil = "MILLIONZ$$$$!!";
        String t1 = "test";
        String t2 = "tattle";
        String t3 = "tutor";
        
        System.out.println( q7.reverse( mil ) );
        System.out.println( q7.reverse( t1 ) );
        System.out.println( q7.highCount( t1, t2, 't' ) );
        System.out.println( q7.highCount( t2, t1, 't' ) );
        System.out.println( q7.highCount( t1, t3, 't' ) );
        System.out.println( q7.highCount( t3, t1, 't' ) );
        System.out.println( q7.highCount( t1, t3, 'x' ) );
    }

    public String reverse( String s )
    {
        String rev = "";
        for ( int i = 0; i < s.length(); i++ )
        {
            rev = s.charAt( i ) + rev;
        }
        return rev;
    }
    
    public String highCount( String s1, String s2, char c )
    {
        int count1 = 0;
        for ( int i = 0; i < s1.length(); i++ )
        {
            if ( s1.charAt( i ) == c )
            {
                count1++;
            }
        }
           
        int count2 = 0;
        for ( int i = 0; i < s2.length(); i++ )
        {
            if ( s2.charAt( i ) == c )
            {
                count2++;
            }
        }
           
        if ( count1 >= count2 )
        {
            return s1;
        }
        else
        {
            return s2;
        }
    }

}