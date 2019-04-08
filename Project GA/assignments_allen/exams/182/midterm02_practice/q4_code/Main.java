public class Main
{
    public static void main( String[] args )
    {
        for ( int i = 1; i <= 5; i++ )
        {
            int num = i;
            for ( int j = 0; j < 4; j++ )
            {
                System.out.print( num + " " );
                num = num * 2;
            }
            System.out.println();
        }
        
        
        int x = 1;
        while ( x <= 5 )
        {
            int num = x;
            int y = 0;
            while( y < 4 )
            {
                System.out.print( num + " " );
                num = num * 2;
                y++;
            }
            System.out.println();
            x++;
        }
        
    }
}
