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
        int num1 = (int)( Math.random() * 5 + 1 );
        int num2 = (int)( Math.random() * 5 + 1 );
        System.out.println( "What is (" + num1 + " * " + num2 + ") ?" );
        System.out.print("Answer: " );
        Scanner scan = new Scanner( System.in );
        if ( scan.hasNextInt() )
        {
            int userAnswer = scan.nextInt();
            int realAnswer = num1 * num2;
            if ( userAnswer == realAnswer )
            {
                System.out.println( "That is correct!" );
            }
            else if ( userAnswer < realAnswer )
            {
                System.out.println( "That is too low (correct answer: " + realAnswer + ")." );
            }
            else
            {
                System.out.println( "That is too high (correct answer: " + realAnswer + ")." );            
            }
        }
        else
        {
            System.out.println( "Sorry, that is an improper response." );
        }
        scan.close();
    }
}