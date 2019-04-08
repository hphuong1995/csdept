
public class Main
{
    public static void main( String[] args )
    {
        String[] words1 = { "This", "is", "a", "test" };
        ArrayWorker worker1 = new ArrayWorker( words1 );
        String longest1 = worker1.getLongest();
        System.out.println( "Longest word is: " + longest1 );
        int[] wordLengths1 = worker1.getLengths();
        System.out.print( "Lengths are: " );
        for ( int i = 0; i < wordLengths1.length; i++ )
        {
            System.out.print( wordLengths1[i] + " " );
        }
        System.out.println();
        System.out.println();

        String[] words2 = new String[0];
        ArrayWorker worker2 = new ArrayWorker( words2 );
        String longest2 = worker2.getLongest();
        System.out.println( "Longest word is: " + longest2 );
        int[] wordLengths2 = worker2.getLengths();
        System.out.print( "Lengths are: " );
        for ( int i = 0; i < wordLengths2.length; i++ )
        {
            System.out.print( wordLengths2[i] + " " );
        }
        System.out.println();
        System.out.println();
    }
}