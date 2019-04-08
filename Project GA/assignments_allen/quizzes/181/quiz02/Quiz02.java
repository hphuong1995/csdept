public class Quiz02
{
  public static void main( String[] args )
    {
    	int num1 = 7;
    	int num2 = 9;
    	
    	num2 = num1;
    	num1 = 5;
    	
    	System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
    	
    	num1 = 7;
    	num2 = 9;
    	
    	num2 = num1; 
    	num1 = num2;
    	
		System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
		
		num1 = 7;
    	num2 = 9;
    	int num3 = num2;
    	
    	num2 = num1; 
    	num1 = num3;
    	
		System.out.printf( "num1 = %d, num2 = %d, num3 = %d\n", num1, num2, num3 );
		
		int xa = 7 / 2  * 5 - 1;
		System.out.printf( "xa = %d\n", xa );
		int xb = 7 / 2  * ( 5 - 1 );
		System.out.printf( "xb = %d\n", xb );
		int xc = 7 / ( 2  * 5 - 1 );
		System.out.printf( "xc = %d\n", xc );
		// int xd = 7 / 2.0 * 5 - 1;
		double xe = 7 / 2.0 * 5 - 1;
		System.out.printf( "xe = %.1f\n", xe );
		double xf = 7 / 2 * 5 - 1;
		System.out.printf( "xf = %.1f\n", xf );
		// int xg = (int) 7 / 2.0 * 5 - 1;
		int xh = (int)( 7 / 2.0 * 5 - 1 );
		System.out.printf( "xh = %d\n", xh );
    }
}
