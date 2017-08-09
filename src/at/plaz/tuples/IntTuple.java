package at.plaz.tuples;

import java.awt.*;

/**
 * Created by Georg Plaz.
 */
public interface IntTuple extends NumberTuple<Integer> {

    int first();

    int second();

    @Override
    default Integer getFirst() {
        return first();
    }

    @Override
    default Integer getSecond() {
        return second();
    }

    IntTupleF toFinal();

    default int sum(){
        return getFirst()+getSecond();
    }

    default IntTuple div(int first, int second){
        return new DefaultIntTupleF(getFirst()/first,getSecond()/second);
    }

    default DefaultIntTupleF abs(){return new DefaultIntTupleF(Math.abs(getFirst()),Math.abs(getSecond()));}

    default int max(){
        return Math.max(getFirst(),getSecond());
    }

    default int min(){
        return Math.min(getFirst(), getSecond());
    }

    default Dimension toAWTDimension() {
        return new Dimension(first(), second());
    }

    default IntTuple min(int first, int second){
        if(bothSmallerEqual(first, second)){
            return this;
        }
        return new DefaultIntTupleF(Math.min(getFirst(),first), Math.min(getSecond(), second));
    }

    default IntTuple min(IntTuple other){
        if(bothSmallerEqual(other)){
            return this;
        }else if (other.bothSmallerEqual(this)){
            return other;
        }
        return new DefaultIntTupleF(Math.min(getFirst(),other.getFirst()), Math.min(getSecond(), other.getSecond()));
    }

    default IntTuple max(IntTuple other){
        if(bothGreaterEqual(other)){
            return this;
        }else if (other.bothGreaterEqual(this)){
            return other;
        }
        return new DefaultIntTupleF(Math.max(getFirst(), other.getFirst()), Math.max(getSecond(), other.getSecond()));
    }

    default boolean bothSmallerEqual(IntTuple other){
        return bothSmallerEqual(other.getFirst(), other.getSecond());
    }

    default boolean bothSmallerEqual(int first, int second){
        return getFirst()<=first && getSecond()<=second;
    }

    default boolean bothGreaterEqual(IntTuple other){
        return getFirst()>=other.getFirst() && getSecond()>=other.getSecond();
    }

    @Override
    default IntTuple toIntTuple(){
        return this;
    }
}
