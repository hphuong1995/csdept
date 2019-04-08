public class Q4
{
	public static void main( String args[] )
	{
		String s1 = "This";
		String s2 = "Is";
		String s3 = "A";
		String s4 = "Test";
		
		s3 = s1;
		s1 = s4;
		s2 = s4;
		s4 = s3;
		
		System.out.println( "s1: " + s1 );
		System.out.println( "s2: " + s2 );
		System.out.println( "s3: " + s3 );
		System.out.println( "s4: " + s4 );
		
		System.out.println( s1.equals( s3 ) );
		System.out.println( s3.equals( s4 ) );
		System.out.println( s2.equals( s4 ) );
		System.out.println( s4.equals( s1 ) );
	}
}