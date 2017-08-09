package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public class DefaultStringTupleF implements StringTupleF {
    private final String first;
    private final String second;

    public DefaultStringTupleF(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public DefaultStringTupleF(String[] values) {
        this(values[0], values[1]);
    }

    public DefaultStringTupleF(Tuple<String,String> tuple) {
        this(tuple.getFirst(), tuple.getSecond());
    }

    public DefaultStringTupleF(String s) {
        this(s, s);
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public StringTupleF toFinal() {
        return this;
    }

    @Override
    public String toString() {
        return ("(\""+first+"\", \""+second+"\")");
    }
}
