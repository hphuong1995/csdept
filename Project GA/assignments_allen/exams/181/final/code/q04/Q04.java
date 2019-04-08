
public class Q04
{
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        ClassA a = new ClassA( 1 ); 
        ClassB b = new ClassB( 2, 3 ); 

        //int u = a.getY();
        
        //int v = b.getY();
        
        int i1 = a.getValue(); 
        int i2 = b.getValue(); 
        int i3 = b.getY();
        
        System.out.printf( "i1 = %d%n", i1 );
        System.out.printf( "i2 = %d%n", i2 );        
        System.out.printf( "i3 = %d%n", i3 );
    }
    
}
