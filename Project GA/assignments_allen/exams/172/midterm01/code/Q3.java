public class Q3
{
    public static void main( String[] args )
    {
        int x = 5 - 3 / 4 * 2;
        System.out.println( x );

        x = (int) ( 5 - 3 / 4.0 * 2 );
        System.out.println( x );

        x = ( 5 - (int) ( 3 / 4.0 ) ) * 2;
        System.out.println( x );

        double y = 5 - 3 / 4 * 2;
        System.out.println( y );

        String s = "Banana!";
        char c = s.charAt( 3 );
        System.out.println( c );

        String s2 = s.substring( 1, 4 );
        System.out.println( s2 );

        String s3 = s + " has length " + s.length();
        System.out.println( s3 );

        x = (int) ( Math.random() * 10 + 10 );
        System.out.println( x );

        x = (int) Math.random() * 10 + 10;
        System.out.println( x );

        boolean b = ( 8 / 2.0 == 4 );
        System.out.println( b );
    }
}
