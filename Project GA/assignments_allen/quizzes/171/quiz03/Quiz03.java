import java.util.Scanner;

public class Quiz03
{
	public static void main( String[] args )
	{
		System.out.println( "\n--------------------------\n" );
		
		String s = "num = ";
		String sx = s + 9 + 2;
		System.out.println( "a: " + sx );

		// String s2 = 9 + 2;
        // sx = "num = " + s2;
		System.out.println( "b: " + "ERROR" );

		String s2 = "num = ";
		sx = s2 + ( 9 + 2 );
		System.out.println( "c: " + sx );
		
		String s3 = "Howdy!";
		char cx = s3.charAt( 1 );
		System.out.println( "d: " + cx );
		
		// cx = s3.charAt( s3.length() );
		System.out.println( "e: " + "ERROR" );

		String s4 = "Howdy!";
	    sx = s4.substring( 2, 4 );
	    System.out.println( "f: " + sx );
	    
	    String s5 = "Howdy!";
	    // cx = s5.substring( 0, 1 );      
	    System.out.println( "g: " + "ERROR" );
	    
	    Scanner scan = new Scanner( "33" );
	    int ix = scan.nextInt();
	    System.out.println( "h: " + ix );
	    
	    Scanner scan2 = new Scanner( "33" );
	    double dx = scan2.nextDouble();  
	    System.out.println( "i: " + dx );    
	    
	    Scanner scan3 = new Scanner( "11 25.5 34" );
	    ix = scan3.nextInt();
	    System.out.println( "j: " + ix );
			
		System.out.println( "\n--------------------------\n" );
	
		int int1 = 15;
		int int2 = 2;
		int int3 = 1;
		double dub1 = 0.0;
		double dub2 = 0.0;
		
		dub1 = int1 / int2 ;
		int2 = (int)( int2 + dub1 );
		dub2 = int1 / 2.0;
		dub1 = dub1 * 2;
		int3 = int1;
		int1 = int2;
		
		System.out.print( "int1 = " + int1 );
		System.out.print( " int2 = " + int2 );
		System.out.println( " int3 = " + int3 );
		System.out.print( "dub1 = " + dub1 );
		System.out.println( " dub2 = " + dub2 );
		
		System.out.println( "\n--------------------------\n" );
	}
}