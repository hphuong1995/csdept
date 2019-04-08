public class Main
{
    public static void main( String[] args )
    {
    	String[] input1 = { "This", "is", "a", "test" };
	    ArrayWorker worker = new ArrayWorker( input1 );
    	System.out.print( "input1: " );
	    worker.printLongest();

        String[] input2 = { "This", "is", "another", "test" };
	    worker = new ArrayWorker( input2 );
    	System.out.print( "input2: " );
	    worker.printLongest();

	    String[] input3 = {}; // empty array
    	worker = new ArrayWorker( input3 );
	    System.out.print( "input3: ");
    	worker.printLongest();
    }
}
