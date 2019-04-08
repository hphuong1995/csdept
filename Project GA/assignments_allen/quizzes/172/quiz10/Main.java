public class Main
{
    public static void main( String[] args )
    {
	int[] input1 = { -1, 0, 3, 2, 1 };
	ArrayWorker worker = new ArrayWorker( input1 );
	System.out.print( "input1: " );
	worker.printArray();
	System.out.println( "Largest = " + worker.getLargest() );

	int[] input2 = {};
	worker = new ArrayWorker( input2 );
	System.out.print( "input2: ");
	worker.printArray();
	System.out.println( "Largest = " + worker.getLargest() );

	// StringWorker sw = new StringWorker( "test" );
	// sw.printCaps();
    }
}
