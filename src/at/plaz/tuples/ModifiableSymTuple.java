package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public interface ModifiableSymTuple<A> extends SymTuple<A> {
    void setFirst(A value);

    void setSecond(A value);

    void swap();
}
