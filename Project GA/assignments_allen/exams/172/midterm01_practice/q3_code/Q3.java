public class Q3 
{
    public static void main( String[] args )
    {
    	int x = 3 / 2 * 4 + 6;
      	System.out.println( x );
      
//      	x = ( 3 / 2.0 * 4 + 6 );
//      	System.out.println( x );
      
		x = (int)( 3 / 2.0 * 4 + 6 );
      	System.out.println( x );
      	
      	double y = 10 / 4 + 11; 
      	System.out.println( y );
      	
      	y = 10.0 / 4 + 11;
      	System.out.println( y );
      	
      	String s = "num = " + (3 + 6);
      	System.out.println( s );
      	
		s = "num = " + 3 + 6;
		System.out.println( s );
		
		x = (int)( Math.random() * 5 + 5);
	 	System.out.println( x );
      
      	x = (int)( Math.random() * 1 + 100);
      	System.out.println( x );
      	
      	x = (int)( Math.random() * 100 ) + 1;
      	System.out.println( x );
      	
      	boolean b = ! (3 != 4 && 4 == 5);
      	System.out.println( b );
      	
      	b = (3 != 3.0 );
      	System.out.println( b );
    }
}
