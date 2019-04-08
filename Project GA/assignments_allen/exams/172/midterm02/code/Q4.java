/**
 * Answer to question 4, CS 120 Midterm 02 (Spring 2017).
 * 
 * @author M. Allen
 */

public class Q4
{
    public static void main( String[] args )
    {
        for ( int i = 1; i <= 5; i++ )
        {
            int prod = i;
            System.out.print( i );
            for ( int j = i + 1; j <= i + 4; j++ )
            {
                System.out.print( " * " + j );
                prod = prod * j;
            }
            System.out.println( " = " + prod );
        }
        
        System.out.println( "--------------" );
        
        int i = 1;
        while ( i <= 5 )
        {
            int prod = i;
            System.out.print( i );
            int j = 1;
            while ( j <= 4 )
            {
                int num = i + j;
                System.out.print( " * " + num );
                prod = prod * num;
                j++;
            }
            System.out.println( " = " + prod );
            i++;
        }

    }

}
