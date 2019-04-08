public class Q05
{
    public static void main( String[] args )
    {
        for ( int i = 0; i < 6; i++ )
        {
            int num = i;
			for ( int j = 0; j < 6; j++ )
			{
				System.out.print( num + " " );
				num = ( num + 1 ) % 6;
			}
			System.out.println();
        }
    }
}