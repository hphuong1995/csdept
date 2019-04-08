public class TripMileage
{
    private double distance, gas;
    private boolean gasIsValid, distanceIsValid;
    
    public void setMileage( double dist, double g )
    {
        gasIsValid = dist >= 0;
        distanceIsValid = g > 0;
        
        if ( isValid() )
        {
            distance = dist;
            gas = g;
        }
    }
    
    public boolean isValid()
    {
        return gasIsValid && distanceIsValid;
    }
}