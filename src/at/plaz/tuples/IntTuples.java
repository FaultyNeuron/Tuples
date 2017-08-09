package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class IntTuples {
    public static final IntTupleF ZEROS = new DefaultIntTupleF(0);
    public static final IntTupleF ONES = new DefaultIntTupleF(1);
    public static final IntTupleF NEGATIVE_ONES = new DefaultIntTupleF(-1);

    public static boolean equals(IntTuple tuple, Object o){
        if (tuple == o) return true;
        if (!(o instanceof IntTuple)) return false;

        IntTuple other = (IntTuple) o;

        return tuple.first() == other.first() && tuple.second() == other.second();
    }

    public static int hashCode(IntTuple tuple) {
        return tuple.first()*31 + tuple.second();
    }

}
