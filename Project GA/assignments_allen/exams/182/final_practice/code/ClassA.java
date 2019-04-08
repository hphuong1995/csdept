public class ClassA
{
    protected int num1, num2;
    
    public ClassA( int i1, int i2 )
    {
        num1 = i1;
        num2 = i2;
    }
    
    public boolean larger()
    {
        return ( num2 > num1 );
    }
}
