/**
 * Answers to question 3 a and b, CS 120 Midterm 02 (Spring 2017).
 * 
 * @author M. Allen
 */

public class Q3
{
    public static void main( String[] args )
    {
        Q3 q3 = new Q3();
        System.out.println( q3.process( "Dogs", 0 ) );
        System.out.println( q3.process( "Dogs", 3 ) );
        System.out.println( q3.process( "Dogs", 4 ) );
        System.out.println( q3.process( "Dogs", 5 ) );
        System.out.println( q3.process( "", 1 ) );

        System.out.println();
        q3.printNums( 4, 4 );
    }

    private char process( String str, int i )
    {
        if ( str.length() == 0 )
        {
            return '0';
        }
        else if ( str.length() <= i )
        {
            return str.charAt( str.length() - 1 );
        }
        else
        {
            return str.charAt( i );
        }
    }

    private void printNums( int num1, int num2 )
    {
        for ( int i = 1; i <= num1; i++ )
        {
            System.out.print( i + ":" );
            for ( int j = 1; j <= num2; j++ )
            {
                int d = j / i;
                System.out.print( " " + d );
            }
            System.out.println();
        }
    }
}
