package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class DefaultTupleF<A, B> implements FinalTuple<A, B> {
    private final A first;
    private final B second;

    public DefaultTupleF(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public A getFirst() {
        return first;
    }

    @Override
    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
}
