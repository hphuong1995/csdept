public class Quiz02
{
  public static void main( String[] args )
    {
    	int num1 = 1;
    	int num2 = 2;
    	
    	num2 = num1;
    	num1 = 0;
    	
    	System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
    	
    	num1 = 2;
    	num2 = 4;
    	
    	num1 = num2;
    	num2 = num1; 
    	
		System.out.printf( "num1 = %d, num2 = %d\n", num1, num2 );
		
		num1 = 1;
    	num2 = 2;
    	int num3 = num1;
    	
    	num1 = num2; 
    	num2 = num3;
    	
		System.out.printf( "num1 = %d, num2 = %d, num3 = %d\n", num1, num2, num3 );
		
		int xa = 9 / 2  * 4 - 1;
		System.out.printf( "xa = %d\n", xa );
		int xb = 9 / 2  * ( 4 - 1 );
		System.out.printf( "xb = %d\n", xb );
		int xc = 9 / ( 2  * 4 - 1 );
		System.out.printf( "xc = %d\n", xc );
		// int xd = 9 / 2.0 * 4 - 1;
		double xe = 9 / 2.0 * 4 - 1;
		System.out.printf( "xe = %.1f\n", xe );
		double xf = 9 / 2 * 4 - 1;
		System.out.printf( "xf = %.1f\n", xf );
		// int xg = (int) 9 / 2.0 * 4 - 1;
		int xh = (int)( 9 / 2.0 * 4 - 1 );
		System.out.printf( "xh = %d\n", xh );
    }
}
