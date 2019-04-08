
public class Q04
{
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        ClassA a = new ClassA( 1 ); 
        ClassB b = new ClassB( 2, 3 ); 
        ClassA c = b;
        
/*        int u = a.getY();
        
        int v = b.getY();
        
        int w = c.getY(); */
        
        int x = a.getValue(); 
        int y = b.getValue(); 
        int z = c.getValue();
        
        System.out.printf( "x = %d%n", x );
        System.out.printf( "y = %d%n", y );        
        System.out.printf( "z = %d%n", z );
    }
    
}
