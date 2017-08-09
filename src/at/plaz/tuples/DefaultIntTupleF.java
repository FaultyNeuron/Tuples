package at.plaz.tuples;

import java.awt.*;
import java.util.Random;

/**
 * Created by Georg Plaz.
 */
public class DefaultIntTupleF implements IntTupleF {
    private final int first;
    private final int second;

    public DefaultIntTupleF(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public DefaultIntTupleF(Tuple<Integer, Integer> tuple) {
        this(tuple.getFirst(), tuple.getSecond());
    }

    public DefaultIntTupleF(int values) {
        this(values, values);
    }

    public DefaultIntTupleF(Integer[] values) {
        this(values[0], values[1]);
    }

    public DefaultIntTupleF(int[] array) {
        this(array[0], array[1]);
    }

    public DefaultIntTupleF(String toParse) {
        this(Tuples.parseIntTuple(toParse));
    }

    public DefaultIntTupleF(StringTuple valuesToParse) {
        this(new Integer(valuesToParse.getFirst()), new Integer(valuesToParse.getSecond()));
    }

    public DefaultIntTupleF(Random random, int upperLimit) {
        this(random.nextInt(upperLimit), random.nextInt(upperLimit));
    }

    public DefaultIntTupleF(Random random, IntTupleF lowerBounds, IntTupleF upperBounds) {
        this(lowerBounds.getFirst()+random.nextInt(upperBounds.first()-lowerBounds.first()),
                lowerBounds.getSecond()+random.nextInt(upperBounds.second()-lowerBounds.second()));
    }

    public DefaultIntTupleF(Point point) {
        this(point.x, point.y);
    }

    public DefaultIntTupleF(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    @Override
    public IntTupleF toFinal() {
        return this;
    }

    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
}
