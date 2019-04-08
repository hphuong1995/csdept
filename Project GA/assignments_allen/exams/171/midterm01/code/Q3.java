public class Q3 
{
    public static void main( String[] args )
    {
    	int x = 7 - 3 / 2 * 2;
      	System.out.println( x );
      
		x = (int)( 7 - 3 / 2.0 * 2 );
      	System.out.println( x );

		x = ( 7 - (int)( 3 / 2.0 ) ) * 2;
      	System.out.println( x );
      	
      	double y = 7 - 3 / 2 * 2; 
      	System.out.println( y );
      	
      	String s = "Banana!";
      	char c = s.charAt( s.length() - 1 );
      	System.out.println( c );
      	
		String s2 = s.substring( 2, 5 );
		System.out.println( s2 );
		
		String s3 = s + " has length " + s.length();
		System.out.println( s3 );
      
      	x = (int)( Math.random() * 100 + 1 );
      	System.out.println( x );
      	
      	x = (int) Math.random() * 100 + 1;
      	System.out.println( x );
      	
      	boolean b = ( 9 / 2 != 8 / 2 );
      	System.out.println( b );
    }
}
