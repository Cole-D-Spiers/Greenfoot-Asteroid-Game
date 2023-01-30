import greenfoot.*;
/**
 * The Util class is a used to provide enhanced functionality for Greenfoot.
 * 
 * @author Nathan Rowbottom
 * @version Feb 14 2022
 */
public class Util  
{
    
    /**
     * Random is used to suppliment the Greenfoot random number generator
     * 
     * @param  min   the minimum value of the range of random values
     * @param  max   the maximum value of the range of random values
     * @return     a random value on the range of (max - min)+min exclusive
     */
    public static int random(int min, int max)
    {
        int range = max - min;
        return (int)random((double)min, (double)max);
    }
    
    /**
     * Random is used to suppliment the random number generator
     * 
     * @param  min   the minimum value of the range of random values
     * @param  max   the maximum value of the range of random values
     * @return     a random value on the range of (max - min)+min exclusive
     */
    public static double random(double min, double max)
    {
        double range = max - min;
        return Math.random()*range+min;
    }
    
    /**
     * distance is used to get distance between two points
     * 
     * @param  x1   the x coord of the first point
     * @param  y1   the y coord of the first point
     * @param  x2   the x coord of the second point
     * @param  y2   the y coord of the second point
     * @return     the pythagorean distance between the two points
     */
    public static double distance(double x1, double y1, double x2, double y2)
    {
        double dx = x2-x1;
        double dy = y2-y1;
        
        return Math.sqrt(dx*dx+dy*dy);//pyth is sqrt(x^2 + y^2)
    }
}
