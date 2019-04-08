public class Q3 
{
    public static void main( String[] args )
    {
    	int x = 20 - 3 * 3 / 2;
      	System.out.println( x );
      
		x = (int)( 20 - 3 * 3 / 2.0  );
      	System.out.println( x );
      	
      	x = 20 - 3 * (int)( 3 / 2.0 );
      	System.out.println( x );
      	
      	x = 20 - 3 * 3 / (int) 2.0;
      	System.out.println( x );
      	
      	double y = 10 + 5 / 2; 
      	System.out.println( y );
      	
      	y = 10 + 5 / 2.0;
      	System.out.println( y );
      	
      	String s = "Pancakes!";
      	String sx = s.substring( 2, 5 );
      	System.out.println( sx );
		
		x = (int)( Math.random() * 20 + 1 );
	 	System.out.println( x );
      
      	x = (int) Math.random() * 5 + 10;
      	System.out.println( x );
      	      	
      	boolean b = ( 9 / 2 ) == ( 8 / 2 );
      	System.out.println( b );
    }
}
