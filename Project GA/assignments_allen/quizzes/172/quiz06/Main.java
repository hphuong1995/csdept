public class Main
{
    public static void main( String[] args )
    {
        for ( int i = 0; i < 5; i++ )
        {
            System.out.print( i + ":" );
            for ( int j = i; j > 0; j-- )
            {
                System.out.print( " " + j );
            }
            System.out.println();
        }
        
        System.out.println( "\n-------------------\n" );
        
        for ( int i = 1; i <= 5; i++ )
        {
        	int num = i;
        	for ( int pow = 1; pow <= 5; pow++ )
        	{
        		System.out.print( num + " " );
        		num = num * i;
        	}
        	System.out.println();
        }
        
        System.out.println();
        
        for ( int i = 1; i <= 5; i++ )
        {
        	for ( int pow = 1; pow <= 5; pow++ )
        	{
        	    int num = (int)( Math.pow( i, pow ) );
        		System.out.print( num + " " );
        	}
        	System.out.println();
        }
        
        
        System.out.println( "\n-------------------\n" );
        
        Main m = new Main();
        m.loop ( 4 );
        System.out.println();
        m.loop2( 5, 2 );
        System.out.println();
        m.loop2( 2, 5 );
        System.out.println();
        m.loop2( 2, 2 );
        System.out.println();
    }
    
    
    public void loop( int num )
    {
       for ( int i = num; i >= 0; i-- )
             System.out.print( i + " " );
    }
    
    public void loop2( int num1, int num2 )
    {
       for ( int i = num1; i >= num2; i-- )
             System.out.print( i + " " );
    }
}