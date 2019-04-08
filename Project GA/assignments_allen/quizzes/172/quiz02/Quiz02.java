public class Quiz02
{
  public static void main( String[] args )
    {
    	int num1 = 1;
    	int num2 = 2;
    	
    	num2 = num1;
    	num1 = 3;
    	
    	System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
    	
    	num1 = 4;
    	num2 = 5;
    	
    	num2 = num1; 
    	num1 = num2;
    	
		System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
		
		num1 = 6;
    	num2 = 7;
    	int num3 = num2;
    	
    	num2 = num1; 
    	num1 = num3;
    	
		System.out.printf( "num1 = %d, num2 = %d, num3 = %d\n", num1, num2, num3 );
		
		int xa = 9 / 2  * 6 - 1;
		System.out.printf( "xa = %d\n", xa );
		int xb = 9 / 2  * ( 6 - 1 );
		System.out.printf( "xb = %d\n", xb );
		int xc = 9 / ( 2  * 6 - 1 );
		System.out.printf( "xc = %d\n", xc );
		// int xd = 9 / 2.0 * 6 - 1;
		double xe = 9 / 2.0 * 6 - 1;
		System.out.printf( "xe = %.1f\n", xe );
		double xf = 9 / 2 * 6 - 1;
		System.out.printf( "xf = %.1f\n", xf );
		// int xg = (int) 9 / 2.0 * 6 - 1;
		int xh = (int)( 9 / 2.0 * 6 - 1 );
		System.out.printf( "xh = %d\n", xh );
    }
}
