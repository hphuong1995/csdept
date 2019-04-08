import java.util.Scanner;

public class Quiz03
{
	public static void main( String[] args )
	{
		System.out.println( "\n--------------------------\n" );
		
		String s = " is a String";
		String sx = 5 + 3 + s;
		System.out.println( "a: " + sx );
		
		// s = 5 + 3;
        // sx = " is a String" + s;
		System.out.println( "b: " + "ERROR" );

        s = "String is ";
		sx = s + 5 + 3;
		System.out.println( "c: " + sx );

        s = "String is ";
		sx = s + (5 + 3);
		System.out.println( "d: " + sx );
				
		String s2 = "Touchdown!";
		char cx = s2.charAt( 0 );
		System.out.println( "e: " + cx );
		
		// cx = s2.charAt( s2.length() );
		System.out.println( "f: " + "ERROR" );

	    sx = s2.substring( 2, 7 );
	    System.out.println( "f: " + sx );
	    	    
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
	
		int int1 = 2;
		int int2 = 3;
		int int3 = int1 / 4;
		double dub1 = 0.0;
		double dub2 = 4.99;

        int1 = int2;
        int2 = (int)( int2 + dub2 );		
		dub1 = int2 / int1;
		dub2 = int2 / 2.0;
        
		System.out.print( "int1 = " + int1 );
		System.out.print( " int2 = " + int2 );
		System.out.println( " int3 = " + int3 );
		System.out.print( "dub1 = " + dub1 );
		System.out.print( " dub2 = " + dub2 );
		
		System.out.println( "\n--------------------------\n" );
	}
}