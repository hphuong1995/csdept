public class Q06
{
    
    public static void main( String[] args )
    {
        
        Q06 q6 = new Q06();
        
    }
    
    private Q06()
    {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 1, 2, 2, 3 };
        int[] arr3 = { 1, 2 };
        
        int[] out1 = sumArrays( arr1, arr2 );
        int[] out2 = sumArrays( arr2, arr3 );
        
        System.out.print( ". " );
        for ( int i = 0; i < out1.length; i++ )
            System.out.print( out1[i] + " " );
        System.out.println( ".\n" );

        System.out.print( ". " );        
        for ( int i = 0; i < out2.length; i++ )
            System.out.println( out2[i] + " " );
		System.out.println( ".\n" );
    }
    
    private int[] sumArrays( int[] a1, int[] a2 )
    {
        int[] output = new int[0];
        
        if ( a1.length == a2.length )
        {
            output = new int[a1.length];
            for ( int i = 0; i < output.length; i++ )
                output[i] = a1[i] + a2[i];
        }
        return output;
    }
    
}