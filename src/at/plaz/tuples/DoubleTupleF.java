package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public interface DoubleTupleF extends NumberTupleF<Double>, DoubleTuple {
    @Override
    default DoubleTupleF toDoubleTupleF() {
        return this;
    }
}
