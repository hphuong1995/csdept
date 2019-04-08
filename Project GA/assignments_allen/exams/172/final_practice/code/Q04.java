public class Q04
{
    public static void main( String[] args )
    {
        ClassA a1 = new ClassA( 0, 0 );
        ClassA a2 = new ClassA( 0, 5 );
        ClassB b1 = new ClassB( 0, 0, 5 );
        ClassB b2 = new ClassB( 0, 6, 9 );
        ClassB b3 = new ClassB( 0, 6, 6 );
        
        System.out.println( a1.larger() );
        System.out.println( a2.larger() );
        System.out.println( b1.larger() );
        System.out.println( b2.larger() );
        System.out.println( b3.larger() );
    }
    
}
