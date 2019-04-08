public class Q4
{
	public static void main( String[] args )
	{
		for ( int i = 1; i <= 5; i++ )
		{
		    int sum = i;
		    System.out.print( i );
		    for ( int j = i + 1; j <= i + 4; j++ )
		    {
		        System.out.print( " + " + j );
		        sum = sum + j;
		    }
		    System.out.println( " = " + sum );
		}
		
		System.out.println();
		
		for ( int i = 1; i <= 5; i++ )
		{
			int sum = i;
			System.out.print( i );
			for ( int j = 1; j <= 4; j++ )
			{
				System.out.print( " + " + ( i + j ) );
				sum = sum + (i + j);
			}
			System.out.println( " = " + sum );
		}
		

	}
}