package at.plaz.tuples;

/**
 * Created by Georg Plaz.
 */
public interface StringTuple extends SymTuple<String> {
    default boolean equals(){
        return getFirst().equals(getSecond());
    }

    default IntTupleF length(){
        return new DefaultIntTupleF(getFirst().length(),getSecond().length());
    }

    default BooleanTupleF isEmpty(){
        return new DefaultBooleanTupleF(getFirst().isEmpty(), getSecond().isEmpty());
    }

    StringTupleF toFinal();

    default boolean bothContain(String s) {
        return getFirst().contains(s) && getSecond().contains(s);
    }

    default boolean anyContains(String s) {
        return getFirst().contains(s) || getSecond().contains(s);
    }

    default boolean containsOther() {
        return getFirst().contains(getSecond()) || getSecond().contains(getFirst());
    }

    default boolean bothEndWith(String s) {
        return getFirst().endsWith(s) && getSecond().endsWith(s);
    }

    default boolean anyEndsWith(String s) {
        return getFirst().endsWith(s) || getSecond().endsWith(s);
    }

    default boolean bothStartWith(String s) {
        return getFirst().startsWith(s) && getSecond().startsWith(s);
    }

    default boolean anyStartsWith(String s) {
        return getFirst().startsWith(s) || getSecond().startsWith(s);
    }

    default boolean bothContainWholeWord(String toTest){
        return StringTuples.containsWholeWord(getFirst(), toTest) &&
                StringTuples.containsWholeWord(getSecond(), toTest);
    }

    default boolean anyContainsWholeWord(String toTest){
        return StringTuples.containsWholeWord(getFirst(), toTest) ||
                StringTuples.containsWholeWord(getSecond(), toTest);
    }

    default boolean bothEqual(String s) {
        return getFirst().equals(s) && getSecond().equals(s);
    }

    default boolean anyEquals(String s) {
        return getFirst().equals(s) || getSecond().equals(s);
    }

    default BooleanTupleF contains(Tuple<String,String> other) {
        return new DefaultBooleanTupleF(getFirst().contains(other.getFirst()),
                getSecond().contains(other.getSecond()));
    }

    default boolean bothContain(Tuple<String,String> other) {
        return getFirst().contains(other.getFirst()) && getSecond().contains(other.getSecond());
    }

    default boolean anyContains(Tuple<String,String> other) {
        return getFirst().contains(other.getFirst()) || getSecond().contains(other.getSecond());
    }

    default boolean containsOtherWholeWord() {
        return StringTuples.containsWholeWord(getSecond(), getFirst()) ||
                StringTuples.containsWholeWord(getFirst(), getSecond());
    }

    default IntTupleF lastIndicesOf(String s){
        return new DefaultIntTupleF(getFirst().lastIndexOf(s),getSecond().lastIndexOf(s));
    }

    default boolean equals(StringTupleF other){
        return getFirst().equals(other.getFirst()) && getSecond().equals(other.getSecond());
    }
}
