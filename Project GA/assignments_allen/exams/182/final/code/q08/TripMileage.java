public class TripMileage
{
    private double distance, gas;
    
    public void setMileage( double dist, double g )
    {
        if ( dist >= 0 && g > 0 )
        {
            distance = dist;
            gas = g;
        }
    }
    
    public double getDistance()
    {
        return distance;
    }
    
    public double getGas()
    {
        return gas;
    }
}