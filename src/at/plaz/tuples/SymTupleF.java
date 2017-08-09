package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public interface SymTupleF<A> extends FinalTuple<A, A>, SymTuple<A>{
    default A[] toArray() {
        return (A[]) new Object[]{getFirst(), getSecond()};
    }

    default SymTupleF<A> swapped(){
        return new DefaultSymTupleF<A>(getSecond(), getFirst());
    }
}
