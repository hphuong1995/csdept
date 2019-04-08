public class Q06
{
    public static void main( String[] args )
    {
        TripMileage tm = new TripMileage();
        tm.setMileage( -3, 0 );
        System.out.println( tm.isValid() );
        tm.setMileage( -3, 1 );
        System.out.println( tm.isValid() );
        tm.setMileage( 0, 0 );
        System.out.println( tm.isValid() );
        tm.setMileage( 0, 1 );
        System.out.println( tm.isValid() );
    }
}