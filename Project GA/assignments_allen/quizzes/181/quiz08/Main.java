public class Main
{
    public static void main( String[] args )
    {
    	int[] input1 = { 1, 0, 3, 2, 1 };
	    ArrayWorker worker = new ArrayWorker( input1 );
    	System.out.print( "input1: " );
	    worker.sumAndPrint();

        int[] input2 = { -1, 0, -2, 1 };
	    worker = new ArrayWorker( input2 );
    	System.out.print( "input2: " );
	    worker.sumAndPrint();

	    int[] input3 = {};
    	worker = new ArrayWorker( input3 );
	    System.out.print( "input3: ");
    	worker.sumAndPrint();
    }
}
