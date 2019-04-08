public class Q03
{
    
    public static void main( String[] args )
    {
        Q03 q3 = new Q03();
        q3.part1();
        System.out.println( "\n" );
        q3.part2();
        System.out.println();
    }
    
    private void part1()
    {
    	double[] d1 = { 1.0, 2.0, 3.0, 4.0, 5.0 };
    	double[] d2 = new double[d1.length * 2];
    	for ( int i = 0; i < d1.length; i++ )
    	{
    		d2[i] = d1[i];
    		d2[d2.length - i - 1] = d2[i];
    	}
    	
    	for ( int i = 0; i < d2.length; i++ )
    		System.out.print( d2[i] + " " );
    }
    
    private void part2()
    {
    	String[] words = { "Every", "good", "bird", "deserves", "feeding" };
    	for ( int w = 0; w < words.length; w++ )
    	{
    		System.out.print( words[w] + " >=" ); 
    		for ( int j = 0; j < words.length; j++ )
    			if ( words[j].length() <= words[w].length() )
    				System.out.print( " " + words[j]);
    		System.out.println();
    	}
    }
}