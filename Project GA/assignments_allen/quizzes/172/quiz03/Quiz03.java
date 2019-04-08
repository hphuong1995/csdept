import java.util.Scanner;

public class Quiz03
{
	public static void main( String[] args )
	{
		System.out.println( "\n--------------------------\n" );
		
		// String s = 3 + 4;
        // String sx = "String is " + s;
		System.out.println( "a: " + "ERROR" );
		
		String s = "String is ";
		String sx = s + 3 + 4;
		System.out.println( "b: " + sx );

		sx = s + ( 9 + 2 );
		System.out.println( "c: " + sx );
		
		String s2 = "Jeepers!";
		char cx = s2.charAt( 0 );
		System.out.println( "d: " + cx );
		
		// cx = s2.charAt( s2.length() );
		System.out.println( "e: " + "ERROR" );

	    sx = s2.substring( 1, 4 );
	    System.out.println( "f: " + sx );
	    	    
	    Scanner scan = new Scanner( "11" );
	    int ix = scan.nextInt();
	    System.out.println( "g: " + ix );
	    
	    Scanner scan2 = new Scanner( "11" );
	    double dx = scan2.nextDouble();  
	    System.out.println( "h: " + dx );    
	    
	    Scanner scan3 = new Scanner( "11 25.5 34.3" );
	    ix = scan3.nextInt();
	    System.out.println( "i: " + ix );
			
		System.out.println( "\n--------------------------\n" );
	
		int int1 = 9;
		int int2 = 2;
		int int3 = 1;
		double dub1 = 0.0;
		double dub2 = 2.9;
		double dub3 = 5.0;

		int3 = int1;
		int1 = int2;
        int2 = (int)( int2 + dub2 );		
		dub1 = int1 / int2 ;
		dub2 = int1 / 2.0;
		dub3 = dub3 * 2;
        
		System.out.print( "int1 = " + int1 );
		System.out.print( " int2 = " + int2 );
		System.out.println( " int3 = " + int3 );
		System.out.print( "dub1 = " + dub1 );
		System.out.print( " dub2 = " + dub2 );
		System.out.println( " dub3 = " + dub3 );
		
		System.out.println( "\n--------------------------\n" );
	}
}