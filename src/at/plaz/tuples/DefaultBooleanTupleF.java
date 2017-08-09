package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class DefaultBooleanTupleF implements BooleanTupleF {
    private final boolean first;
    private final boolean second;

    public DefaultBooleanTupleF(boolean first, boolean second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean first() {
        return first;
    }

    @Override
    public boolean second() {
        return second;
    }

    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
}
