public class Driver
{
    // Place global array variable here
    private Window[] windows;
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Driver d = new Driver();
        d.makeWindows();
    }
    
    // Write method here to fill a global array of 10 things.
    // Things with an even array index (0, 2, ...) should
    // be normal Window objects, and things with an odd index
    // should be BetterWindow objects. Each should have the
    // title "Window X" (where X is its index in the array).
    // Each should be of size (500 x 500), at location (20,20).
    private void makeWindows()
    {
        windows = new Window[10];
        for ( int i = 0; i < windows.length; i++ )
        {
            if ( i % 2 == 0 )
                windows[i] = new Window( "Window " + i );
            else
                windows[i] = new BetterWindow( "WINDOW " + i );
            
            windows[i].setLocation( 20, 20 );
            windows[i].setSize( 500, 500 );
        }
    }
    
}
