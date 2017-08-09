package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class DefaultSymTupleF<A> implements SymTupleF<A> {
    private A first;
    private A second;

    public DefaultSymTupleF(A first, A second) {
        this.first = first;
        this.second = second;
    }

    public DefaultSymTupleF(Tuple<A, A> tuple) {
        this(tuple.getFirst(), tuple.getSecond());
    }

    public DefaultSymTupleF(A values) {
        this(values, values);
    }

    public DefaultSymTupleF(A[] values) {
        this(values[0], values[1]);
    }

    @Override
    public A getFirst() {
        return first;
    }

    @Override
    public A getSecond() {
        return second;
    }


    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
}
