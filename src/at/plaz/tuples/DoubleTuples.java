package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class DoubleTuples {
    public static final DoubleTupleF ZEROS = new DefaultDoubleTupleF(0);
    public static final DoubleTupleF HALVES = new DefaultDoubleTupleF(0.5);
    public static final DoubleTupleF ONES = new DefaultDoubleTupleF(1);
    public static final DoubleTupleF NEGATIVE_ONES = new DefaultDoubleTupleF(-1);
    public static final DoubleTupleF TWOS = new DefaultDoubleTupleF(2);
    public static final DoubleTupleF MIN = new DefaultDoubleTupleF(-Double.MAX_VALUE);
    public static final DoubleTupleF MAX = new DefaultDoubleTupleF(Double.MAX_VALUE);
    public static final double EPSILON_VALUE = 0.00000001;
    public static final DoubleTupleF EPSILON = new DefaultDoubleTupleF(EPSILON_VALUE);

    public static boolean equals(DoubleTuple tuple, Object o) {
        if (tuple == o) return true;
        if (!(o instanceof DoubleTuple)) return false;

        DoubleTuple other = (DoubleTuple) o;
        return tuple.first() == other.first() && tuple.second() == other.second();
    }
    
    public static DoubleTupleF add(double firstX, double firstY, double secondX, double secondY) {
        return new DefaultDoubleTupleF(firstX + secondX, firstY + secondY);
    }
    
    public static DoubleTupleF add(DoubleTuple first, double secondX, double secondY) {
        return add(first.first(), first.second(), secondX, secondY);
    }

    public static DoubleTupleF add(double firstX, double firstY, DoubleTuple second) {
        return add(firstX, firstY, second.first(), second.second());
    }
    
    public static DoubleTupleF add(DoubleTuple first, DoubleTuple second) {
        return add(first.first(), first.second(), second.first(), second.second());
    }
    
    public static DoubleTupleF add(DoubleTuple first, double value) {
        return add(first.first(), first.second(), value, value);
    }
    
    public static DoubleTupleF subtract(double firstX, double firstY, double secondX, double secondY) {
        return new DefaultDoubleTupleF(firstX - secondX, firstY - secondY);
    }
    
    public static DoubleTupleF subtract(DoubleTuple first, double secondX, double secondY) {
        return subtract(first.first(), first.second(), secondX, secondY);
    }

    public static DoubleTupleF subtract(double firstX, double firstY, DoubleTuple second) {
        return subtract(firstX, firstY, second.first(), second.second());
    }
    
    public static DoubleTupleF subtract(DoubleTuple first, DoubleTuple second) {
        return subtract(first.first(), first.second(), second.first(), second.second());
    }
    
    public static DoubleTupleF subtract(DoubleTuple first, double value) {
        return subtract(first.first(), first.second(), value, value);
    }
    
    public static DoubleTupleF multiply(double firstX, double firstY, double secondX, double secondY) {
        return new DefaultDoubleTupleF(firstX * secondX, firstY * secondY);
    }
    
    public static DoubleTupleF multiply(DoubleTuple first, double secondX, double secondY) {
        return multiply(first.first(), first.second(), secondX, secondY);
    }

    public static DoubleTupleF multiply(double firstX, double firstY, DoubleTuple second) {
        return multiply(firstX, firstY, second.first(), second.second());
    }
    
    public static DoubleTupleF multiply(DoubleTuple first, DoubleTuple second) {
        return multiply(first.first(), first.second(), second.first(), second.second());
    }
    
    public static DoubleTupleF multiply(DoubleTuple first, double value) {
        return multiply(first.first(), first.second(), value, value);
    }
    
    public static DoubleTupleF divide(double firstX, double firstY, double secondX, double secondY) {
        return new DefaultDoubleTupleF(firstX / secondX, firstY / secondY);
    }
    
    public static DoubleTupleF divide(DoubleTuple first, double secondX, double secondY) {
        return divide(first.first(), first.second(), secondX, secondY);
    }

    public static DoubleTupleF divide(double firstX, double firstY, DoubleTuple second) {
        return divide(firstX, firstY, second.first(), second.second());
    }
    
    public static DoubleTupleF divide(DoubleTuple first, DoubleTuple second) {
        return divide(first.first(), first.second(), second.first(), second.second());
    }
    
    public static DoubleTupleF divide(DoubleTuple first, double value) {
        return divide(first.first(), first.second(), value, value);
    }

    public static DoubleTupleF normalize(DoubleTuple tuple) {
        return divide(tuple, tuple.length());
    }

    public static DoubleTupleF round(DoubleTuple tuple, int precision) {
        double precisionPow = Math.round(Math.pow(10, precision));
        return new DefaultDoubleTupleF(Util.round(tuple.first(), precisionPow), Util.round(tuple.second(), precisionPow));
    }
    
}
