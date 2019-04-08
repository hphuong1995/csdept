public class Q3 
{
    public static void main( String[] args )
    {
    	int x = 10 - 5 * 3 / 2;
      	System.out.println( x );
      
		x = (int)( 10 - 5 * 3 / 2.0  );
      	System.out.println( x );
      	
      	x = 10 - 5 * (int)( 3 / 2.0 );
      	System.out.println( x );
      	
      	x = 10 - 5 * 3 / (int) 2.0;
      	System.out.println( x );
      	
      	double y = 30 + 7 / 2; 
      	System.out.println( y );
      	
      	y = 30 + 7 / 2.0;
      	System.out.println( y );
      	
      	String s = "Banana!";
      	String sx = s.substring( 1, 4 );
      	System.out.println( sx );
		
		x = (int)( Math.random() * 30 + 1 );
	 	System.out.println( x );
      
      	x = (int)( Math.random() * 10 + 10 );
      	System.out.println( x );
      	      	
      	boolean b = (5 == 5.0);
      	System.out.println( b );
    }
}
