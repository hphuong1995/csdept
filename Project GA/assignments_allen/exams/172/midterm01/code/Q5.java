  /**
 * Random number guessing "game".
 * (Midterm 01, question 06.)
 *
 * @author M. Allen
 */
import java.util.Scanner;

public class Q5
{
    public static void main( String[] args )
    {
        System.out.print( "Please guess an integer between 1 and 100 (inclusive): " );
        Scanner scan = new Scanner( System.in );
        if ( scan.hasNextInt() )
        {
            int i = scan.nextInt();
            int rand = (int) ( Math.random() * 100 + 1 );
            if ( i > 100 )
            {
                System.out.println( "That is an improper guess..." );
            }
            else if ( i < 1 )
            {
                System.out.println( "That is an improper guess..." );
            }
            else if ( i == rand )
            {
                System.out.println( "You guessed right!" );
            }
            else if ( i < rand )
            {
                System.out.println( "You guessed too low (correct answer: " + rand + ")." );
            }
            else
            {
                System.out.println( "You guessed too high (correct answer: " + rand + ")." );
            }
        }
        else
        {
            System.out.println( "That is an improper guess..." );
        }
        scan.close();
    }
}