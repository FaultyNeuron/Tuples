package at.plaz.tuples;

/**
 * Created by Georg Plaz
 */
public class Tripel<A,B,C> {
    private final A first;
    private final B second;
    private final C third;

    public Tripel(Tuple<A, B> tuple, C third) {
        this(tuple.getFirst(), tuple.getSecond(), third);
    }

    public Tripel(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ", " + getThird() + ")";
    }
}