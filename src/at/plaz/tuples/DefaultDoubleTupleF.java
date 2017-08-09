package at.plaz.tuples;

import java.awt.*;
import java.util.Random;

/**
 * Created by Georg Plaz.
 */
public class DefaultDoubleTupleF implements DoubleTupleF {
    private final double first;
    private final double second;

    public DefaultDoubleTupleF(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public DefaultDoubleTupleF(DoubleTuple tuple) {
        this(tuple.first(), tuple.second());
    }

    public DefaultDoubleTupleF(Tuple<Double, Double> tuple) {
        this(tuple.getFirst(), tuple.getSecond());
    }

    public DefaultDoubleTupleF(double values) {
        this(values, values);
    }

    public DefaultDoubleTupleF(Double[] values) {
        this(values[0], values[1]);
    }

    public DefaultDoubleTupleF(double[] array) {
        this(array[0], array[1]);
    }

    public DefaultDoubleTupleF(String toParse) {
        this(Tuples.parseDoubleTuple(toParse));
    }

    public DefaultDoubleTupleF(StringTuple valuesToParse) {
        this(Double.parseDouble(valuesToParse.getFirst()), Double.parseDouble(valuesToParse.getSecond()));
    }

    public DefaultDoubleTupleF(Random random, double scalar) {
        this(random, 0, 0, scalar, scalar);
    }

    public DefaultDoubleTupleF(Random random, double upperBoundX, double upperBoundY) {
        this(random, 0, 0, upperBoundX, upperBoundY);
    }

    public DefaultDoubleTupleF(Random random, DoubleTuple upperBound) {
        this(random, 0, 0, upperBound.first(), upperBound.second());
    }

    public DefaultDoubleTupleF(Random random, DoubleTuple lowerBounds, DoubleTuple upperBounds) {
        this(random, lowerBounds.first(), lowerBounds.second(), upperBounds.first(), upperBounds.second());
    }

    public DefaultDoubleTupleF(Random random, double lowerX, double lowerY, double upperX, double upperY) {
        this(lowerX+random.nextDouble()*(upperX-lowerX),
                lowerY+random.nextDouble()*(upperY-lowerY));
    }

    public DefaultDoubleTupleF(Point point) {
        this(point.getX(), point.getY());
    }

    public DefaultDoubleTupleF(Dimension dimension) {
        this(dimension.getWidth(), dimension.getHeight());
    }

    public double first() {
        return first;
    }

    public double second() {
        return second;
    }

    @Override
    public DoubleTupleF toFinal() {
        return this;
    }

    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
}
