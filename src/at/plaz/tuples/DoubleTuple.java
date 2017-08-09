package at.plaz.tuples;

import java.util.Collection;

/**
 * Created by Georg Plaz.
 */
public interface DoubleTuple extends NumberTuple<Double>{
    @Override
    default DoubleTuple toDoubleTuple(){
        return this;
    }

    double first();

    double second();

    DoubleTupleF toFinal();

    @Override
    default Double getFirst() {
        return first();
    }

    @Override
    default Double getSecond() {
        return second();
    }

    default BooleanTupleF isNaN(){
        return new DefaultBooleanTupleF(Double.isNaN(first()), Double.isNaN(second()));
    }

    default boolean anyIsNaN(){
        return Double.isNaN(first()) || Double.isNaN(second());
    }

    default IntTupleF roundToIntTuple(){
        return new DefaultIntTupleF(Math.round(getFirst().floatValue()), Math.round(getSecond().floatValue()));
    }

    default double max(){
        return Math.max(first(), second());
    }

    default double min(){
        return Math.min(first(), second());
    }

    default double[] toArrayUnboxed() {
        return new double[]{first(), second()};
    }

    default DoubleTuple min(double first, double second) {
        if(first()<=first && second()<=second){
            return this;
        }
        return new DefaultDoubleTupleF(Math.min(first(), first), Math.min(second(), second));
    }

    default DoubleTupleF minF(DoubleTuple other) {
        if(bothSmallerEqual(other)){
            if (this instanceof DoubleTupleF) {
                return (DoubleTupleF) this;
            }
        }else if(other.bothSmallerEqual(this)){
            if (other instanceof DoubleTupleF) {
                return (DoubleTupleF) other;
            }
        }
        return new DefaultDoubleTupleF(Math.min(first(), other.first()), Math.min(second(), other.second()));
    }

    default DoubleTuple min(DoubleTuple other) {
        if(bothSmallerEqual(other)){
            return this;
        }else if(other.bothSmallerEqual(this)){
            return other;
        }
        return new DefaultDoubleTupleF(Math.min(first(), other.first()), Math.min(second(), other.second()));
    }

    default DoubleTuple max(double first, double second) {
        if(first()>=first && second()>=second){
            return this;
        }
        return new DefaultDoubleTupleF(Math.max(first(), first), Math.max(second(), second));
    }

    default DoubleTuple max(DoubleTuple other) {
        if(bothGreaterEqual(other)){
            return this;
        }else if(other.bothGreaterEqual(this)){
            return other;
        }
        return new DefaultDoubleTupleF(Math.max(first(), other.first()), Math.max(second(), other.second()));
    }

    default DoubleTupleF maxF(DoubleTuple other) {
        if(bothGreaterEqual(other)){
            if (this instanceof DoubleTupleF) {
                return (DoubleTupleF) this;
            }
        }else if(other.bothGreaterEqual(this)){
            if (other instanceof DoubleTupleF) {
                return (DoubleTupleF) other;
            }
        }
        return new DefaultDoubleTupleF(Math.max(first(), other.first()), Math.max(second(), other.second()));
    }

    default boolean containedIn(Tuple<DoubleTuple, DoubleTuple> box){
        return bothGreaterEqual(box.getFirst()) &&
                bothSmallerEqual(box.getSecond());
    }

    default boolean containedIn(Collection<Tuple<DoubleTuple, DoubleTuple>> boxes){
        for(Tuple<DoubleTuple, DoubleTuple> box : boxes){
            if(containedIn(box)){
                return true;
            }
        }
        return false;
    }

    default boolean bothGreaterEqual(DoubleTuple other){
        return bothGreaterEqual(other.first(), other.second());
    }

    default boolean bothGreaterEqual(double first, double second){
        return first()>=first && second()>=second;
    }

    default boolean anyGreaterEqual(DoubleTuple other){
        return anyGreaterEqual(other.first(), other.second());
    }

    default boolean anyGreaterEqual(double first, double second){
        return first()>=first || second()>=second;
    }

    default boolean bothSmallerEqual(DoubleTuple other){
        return first()<=other.first() && second()<=other.second();
    }

    default boolean anySmallerEqual(DoubleTuple other){
        return first()<=other.first() || second()<=other.second();
    }

    default double sum() {
        return first() + second();
    }

    default boolean equals(double first, double second){
        return first() == first && second() == second;
    }

    default double distance(DoubleTuple other) {
        return DoubleTuples.subtract(this, other).length();
    }

    default double length(){
        return Math.sqrt(first() * first() + second() * second());
    }

}
