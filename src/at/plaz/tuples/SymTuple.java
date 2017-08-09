package at.plaz.tuples;

import java.util.Iterator;

/**
 * Created by Georg Plaz
 */
public interface SymTuple<A> extends Tuple<A, A>, Iterable<A>{
    default A[] toArray() {
        return (A[]) new Object[]{getFirst(), getSecond()};
    }

    @Override
    default Iterator<A> iterator() {
        return new Iter(this);
    }

    class Iter<A> implements Iterator<A> {
        private SymTuple<A> tuple;
        short pos = 0;

        public Iter(SymTuple<A> tuple) {
            this.tuple = tuple;
        }

        @Override
        public boolean hasNext() {
            return pos<=1;
        }

        @Override
        public A next() {
            switch (pos++){
                case 0:
                    return tuple.getFirst();
                case 1:
                    return tuple.getSecond();
                default:
                    return null;
            }
        }
    }



    default A get(int index) {
        return index==0 ? getFirst() : getSecond();
    }
}
