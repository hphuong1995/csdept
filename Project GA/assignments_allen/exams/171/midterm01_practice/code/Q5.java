import java.util.Scanner;

public class Q5
{
    public static void main( String[] args )
    {
       Scanner scan = new Scanner( System.in );
       
       System.out.print( "Please enter an integer value: " );
       int i = 0;
       if ( scan.hasNextInt() )
           i = scan.nextInt();
        
        int abs = i;
        if ( abs < 0 )
            abs = -1 * abs;
        System.out.println( "Absolute value: " + abs );
            
        int cube = i * i * i;
        System.out.println ( "Cube: " + cube );
               
       scan.close();
    }
}
