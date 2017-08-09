package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public interface Tuple<A, B> {
    A getFirst();

    B getSecond();

    default String[] toStringArray() {
        return new String[]{getFirst().toString(), getSecond().toString()};
    }

    default boolean anyIsNull(){
        return getFirst()==null || getSecond()==null;
    }

    default Tuple<B, A> flip(){
        return new DefaultTupleF<>(getSecond(), getFirst());
    }

    default boolean equals(){
        return getFirst().equals(getSecond());
    }
}
