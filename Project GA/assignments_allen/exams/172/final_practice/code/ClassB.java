public class ClassB extends ClassA
{
    private int num3;
    
    public ClassB( int i1, int i2, int i3 )
    {
        super( i1, i2 );
        num3 = i3;
    }
    
    public boolean larger()
    {
        boolean large1 = super.larger();
        boolean large2 = num3 > num2 ;
        return large1 && large2 ;
    }
}
