public class Main
{
    public static void main( String[] args )
    {
	int x = 0;
	while ( x < 10 )
	{
	    System.out.println( x + 1 );
	    x++ ;
	}

	System.out.println();

	int y = 1;
	while ( y < 10 )
	{
	    System.out.println( y );
	    y = y + 2;
	}

	System.out.println();

	int w = 1;
	while ( w < 16 )
	{
	    System.out.println( w );
	    w = w * 2;
	}

	System.out.println();

	
//	  int v = 0;
//	  while ( v < 5 )
//	  {
//	  System.out.println( v );
//	  v = v + 1 / 5;
//	  }
//	 
//
//	System.out.println();

	int z = 10;
	while ( z < 5 )
	{
	    System.out.println( z );
	    z = z * 2;
	}

	System.out.println( "\n------------------------\n" );
	
	for ( int i = 1; i <= 6; i++ )
    {
    	System.out.print( i + ": " );
        if ( i % 2 == 0 )
        {
        	System.out.println( "TRUE" );
        }
        else
        {
            System.out.println( "FALSE" );
        }
    }
	}
}
