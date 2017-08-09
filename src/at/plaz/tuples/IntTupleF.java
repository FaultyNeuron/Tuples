package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public interface IntTupleF extends NumberTupleF<Integer>, IntTuple {
    @Override
    default IntTupleF toIntTupleF() {
        return this;
    }
}
