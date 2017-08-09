package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public interface NumberTuple<A extends Number> extends SymTuple<A> {
    default DoubleTuple toDoubleTuple(){
        return new DefaultDoubleTupleF(getFirst().doubleValue(), getSecond().doubleValue());
    }

    default DoubleTupleF toDoubleTupleF(){
        return new DefaultDoubleTupleF(getFirst().doubleValue(), getSecond().doubleValue());
    }

    default IntTuple toIntTuple(){
        return new DefaultIntTupleF(getFirst().intValue(), getSecond().intValue());
    }

    default IntTupleF toIntTupleF(){
        return new DefaultIntTupleF(getFirst().intValue(), getSecond().intValue());
    }

}
