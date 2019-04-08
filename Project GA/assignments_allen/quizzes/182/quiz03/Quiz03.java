import java.util.Scanner;

public class Quiz03
{
	public static void main( String[] args )
	{
		System.out.println( "\n--------------------------\n" );
		
		// String s = 11;
		// String x = x + " is a String";
		System.out.println( "a: ERROR" );
		
		String s = " is a String";
        String x = 11 + s;
		System.out.println( "b: " + x );

		x = "String is " + 1 + 2;
		System.out.println( "c: " + x );

		x = "String is " + (1 + 2);
		System.out.println( "d: " + x );
				
		String s2 = "Cheese curds";
		char cx = s2.charAt( 1 );
		System.out.println( "e: " + cx );
		
	    // cx = s2.charAt( s2.length() );
		System.out.println( "f: ERROR" );

	    x = s2.substring( 2, 7 );
	    System.out.println( "f: " + x );
	    	    
	    Scanner scan = new Scanner( "86" );
	    int ix = scan.nextInt();
	    System.out.println( "g: " + ix );
	    
	    Scanner scan2 = new Scanner( "86" );
	    double dx = scan2.nextDouble();  
	    System.out.println( "h: " + dx );    
	    
	    Scanner scan3 = new Scanner( "86 Hines Ward" );
	    ix = scan3.nextInt();
	    System.out.println( "i: " + ix );
			
		System.out.println( "\n--------------------------\n" );
	
		int int1 = 1;
		int int2 = 2;
		int int3 = int1 / 2;
		double dub1 = 0.0;
		double dub2 = 5.99;

        int2 = (int)( int2 + dub2 );		
		dub1 = int1 / 2;
		dub2 = int2 / 2.0;
        
		System.out.print( "int1 = " + int1 );
		System.out.print( " int2 = " + int2 );
		System.out.println( " int3 = " + int3 );
		System.out.print( "dub1 = " + dub1 );
		System.out.print( " dub2 = " + dub2 );
		
		System.out.println( "\n--------------------------\n" );
	}
}