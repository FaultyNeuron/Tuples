package at.plaz.tuples;

import java.util.regex.Pattern;

/**
 * Created by Georg Plaz.
 */
public class StringTuples {
    public static final StringTupleF EMPTY = new DefaultStringTupleF("", "");

    public static StringTuple trim(StringTuple tuple){
        String firstTrimmed = tuple.getFirst().trim();
        String secondTrimmed = tuple.getSecond().trim();
        if(firstTrimmed.equals(tuple.getFirst()) && secondTrimmed.equals(tuple.getSecond())){
            return tuple;
        }else{
            return new DefaultStringTupleF(firstTrimmed, secondTrimmed);
        }
    }

    public static StringTuple toLowerCase(StringTuple tuple){
        String firstLower = tuple.getFirst().toLowerCase();
        String secondLower = tuple.getSecond().toLowerCase();
        if(tuple.getFirst().equals(firstLower) && tuple.getSecond().equals(secondLower)){
            return tuple;
        }
        return new DefaultStringTupleF(firstLower, secondLower);
    }

    public static StringTuple remove(StringTuple tuple, String toRemove) {
        if(tuple.anyContains(toRemove)){
            return new DefaultStringTupleF(remove(tuple.getFirst(), toRemove), remove(tuple.getSecond(), toRemove));
        }else{
            return tuple;
        }
    }

    private static String remove(String from, String toRemove){
        return Pattern.compile(Pattern.quote(toRemove)).matcher(from).replaceAll("");
    }

    public static StringTuple remove(StringTuple tuple, String... toRemove) {
        String first = tuple.getFirst();
        String second = tuple.getSecond();
        boolean changed = false;
        for(String s:toRemove) {
            if (first.contains(s) || second.contains(s)) {
                first = remove(first, s);
                second = remove(second, s);
                changed = true;
            }
        }
        if(!changed) {
            return tuple;
        }else{
            return new DefaultStringTupleF(first, second);
        }
    }

    public static StringTuple swap(StringTuple tuple){
        return new DefaultStringTupleF(tuple.getSecond(), tuple.getFirst());
    }

    public static StringTuple replace(StringTuple tuple, char oldChar, char newChar) {
        return new DefaultStringTupleF(tuple.getFirst().replace(oldChar, newChar), tuple.getSecond().replace(oldChar, newChar));
    }

    public static StringTuple replace(StringTuple tuple, String target, String replacement) {
        return new DefaultStringTupleF(tuple.getFirst().replace(target, replacement), tuple.getSecond().replace(target, replacement));
    }

    public static StringTuple substring(StringTuple tuple, IntTupleF beginIndex, IntTupleF endIndex){
        return new DefaultStringTupleF(tuple.getFirst().substring(beginIndex.getFirst(), endIndex.getFirst()),
                tuple.getSecond().substring(beginIndex.getSecond(), endIndex.getSecond()));
    }

    public static StringTuple split(StringTuple tuple, String regex, int index){
        return new DefaultStringTupleF(tuple.getFirst().split(regex)[index], tuple.getSecond().split(regex)[index]);
    }

    public static String toString(StringTuple tuple){
        return "(\""+ tuple.getFirst()+"\", \""+tuple.getSecond()+"\")";
    }

    public static boolean containsWholeWord(String lookIn, String lookFor) {
        StringBuilder builder = new StringBuilder(" ").append(lookFor);
        return lookIn.endsWith(builder.toString()) ||
                lookIn.contains(builder.append(" ").toString()) ||
                lookIn.startsWith(builder.substring(1)) ||
                lookIn.equals(lookFor);
    }
}
