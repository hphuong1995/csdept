public class ClassB extends ClassA { 
    private int y;

    public ClassB( int z, int yin ) {
        super(z);
        y = yin; 
    }
    
    public int getY() { 
        return y;
    }

    public int getValue() {
        return x + y; 
    }
}