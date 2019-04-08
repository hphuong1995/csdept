/**
 *
 *
 * @author M. Allen
 */

public class Q1
{
    public static void main( String[] args )
    {
        for ( int i = 0; i < 10; i++ )
            System.out.println( i );
        
        // System.out.println( "Final value of i = " + i );
        
        // int i = 0;
        // String s = "Test";
        // while ( i <= s.length() )
        // System.out.println( s.charAt( i ) );
        
        int num = (int) methodA() / 5;
        System.out.println( num );
        
        double num2 = methodB();
        System.out.println( num2 );
        
        int num3 = methodC().length();
        System.out.println( num3 );
    }
    
    private static double methodA()
    {
        return 7.3;
    }
    
    private static int methodB()
    {
        return -11;
    }
    
    private static String methodC()
    {
        return "Bananas";
    }
}
