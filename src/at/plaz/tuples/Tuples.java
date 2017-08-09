package at.plaz.tuples;

import java.util.regex.Pattern;

/**
 * Created by Georg Plaz.
 */
public class Tuples {
    public static final String DELIMITER = ",";
    public static final String START = "(";
    public static final String END = ")";

    public static <A, B> boolean equals(Tuple<A, B> tuple, Object o) {
        if (tuple == o) return true;
        if (!(o instanceof Tuple)) return false;

        Tuple oTuple = (Tuple) o;

        if (tuple.getFirst() != null ? !tuple.getFirst().equals(oTuple.getFirst()) : oTuple.getFirst() != null) return false;
        if (tuple.getSecond() != null ? !tuple.getSecond().equals(oTuple.getSecond()) : oTuple.getSecond() != null) return false;

        return true;
    }

    public static <A, B> int hashCode(Tuple<A, B> tuple) {
        int result = tuple.getFirst() != null ? tuple.getFirst().hashCode() : 0;
        result = 31 * result + (tuple.getSecond() != null ? tuple.getSecond().hashCode() : 0);
        return result;
    }

    public static DoubleTupleF parseDoubleTuple(String toParse){
        try {
            return new DefaultDoubleTupleF(getValues(toParse));
        }catch (Exception exception){
            throw new NumberFormatException("could not parse \""+toParse+"\" to a DoubleTuple!");
        }
    }

    public static IntTupleF parseIntTuple(String toParse){
        try {
            return new DefaultIntTupleF(getValues(toParse));
        }catch (Exception exception){
            throw new NumberFormatException("could not parse \""+toParse+"\" to an IntTuple!");
        }
    }

    private static StringTuple getValues(String toParse) {
        StringTuple values = StringTuples.remove(new DefaultStringTupleF(toParse.split(Pattern.quote(DELIMITER))), " ");
        if (values.getFirst().startsWith(START) && values.getSecond().endsWith(END)) {
            values = new DefaultStringTupleF(values.getFirst().substring(1), values.getSecond().substring(0, values.getSecond().length() - 1));
        }
        return values;
    }
}
