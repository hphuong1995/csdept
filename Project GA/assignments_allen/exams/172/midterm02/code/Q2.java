/**
 * Answers to question 3 a and b, CS 120 Midterm 02 (Spring 2017).
 * 
 * @author M. Allen
 */

public class Q2
{
    public static void main( String[] args )
    {
        int num = 5;
        while ( num >= 0 )
        {
            System.out.println( num );
            num--;
        }
        
        System.out.println( "------------" );
        
        for ( int i = 1; i <= 20; i = i * 2 )
            System.out.println( i );
    }
    
/*
    private int checkNums( int i, int j )
    {
        if ( i < j )
            return i;
        else if ( i > j )
            return j;
    }
*/
    
    private int checkNums( int i, int j )
    {
        if ( j > i )
            return i;
        else
            return j;
    }
}
