public class TripMileage
{
    private double distance, gas;
    
    public void setMileage( double dist, double g )
    {
        boolean gasIsValid = dist >= 0;
        boolean distanceIsValid = g > 0;
        
        if ( gasIsValid && distanceIsValid )
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