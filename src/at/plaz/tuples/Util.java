package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class Util {
    public static double round(double toRound, double precisionPow){
        return Math.round(toRound*precisionPow)/precisionPow;
    }
}
