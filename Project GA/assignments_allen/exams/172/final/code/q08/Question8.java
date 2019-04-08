public class Question8
{
    public static void main( String[] args )
    {
        TripMileage tm = new TripMileage();
       
        tm.setMileage( 0, 5 );
        System.out.println( "Distance: " + tm.getDistance() + ", Gas = " + tm.getGas() + "\n" );

        tm.setMileage( 10, 10 );
        System.out.println( "Distance: " + tm.getDistance() + ", Gas = " + tm.getGas() + "\n" );

        tm.setMileage( -3, 5 );
        System.out.println( "Distance: " + tm.getDistance() + ", Gas = " + tm.getGas() + "\n" );
        
        tm.setMileage( 5, 0 );
        System.out.println( "Distance: " + tm.getDistance() + ", Gas = " + tm.getGas() + "\n" );
    }
}