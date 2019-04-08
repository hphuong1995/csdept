public class Q03
{
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        char[] blizzard = {'Z', 'Z', 'Y', 'X', 'W'};
        System.out.println( blizzard.length );
        System.out.println( blizzard[1] != blizzard[2] );
        System.out.println( blizzard[3] >= blizzard[3] ); 
        System.out.println( "COLD" + blizzard[2] + blizzard[2 - 1] );
        System.out.println( blizzard[blizzard.length - 1] );
        
        System.out.println( "--------------------------" );
        
        int base = 2; 
        while( base < 6 ) 
        {
            int pow = base;
            for( int e = 2; e != 4; e++ ) 
            {
                pow = pow * pow;
                System.out.println( pow + ", " + e ); 
            }
            base = base + 3; 
        }
    }
    
}
