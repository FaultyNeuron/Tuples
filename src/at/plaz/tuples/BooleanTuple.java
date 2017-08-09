package at.plaz.tuples;


/**
 * Created by Georg Plaz.
 */
public interface BooleanTuple extends SymTuple<Boolean> {
    boolean first();

    boolean second();

    @Override
    default Boolean getFirst() {
        return first();
    }

    @Override
    default Boolean getSecond() {
        return second();
    }

    default boolean and(){
        return first() && second();
    }

    default boolean or(){
        return first() || second();
    }
}
