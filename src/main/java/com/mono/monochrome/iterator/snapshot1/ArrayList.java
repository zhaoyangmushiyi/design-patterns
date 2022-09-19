package com.mono.monochrome.iterator.snapshot1;

import java.util.Iterator;

/**
 * @author monochrome
 * @date 2022/9/19
 */
public class ArrayList<E> extends java.util.ArrayList<E>{

    @Override
    public java.util.Iterator<E> iterator() {

        return new SnapshotArrayIterator<>(this);
    }

    public class SnapshotArrayIterator<E> implements Iterator<E> {
        private int cursor;
        private ArrayList<E> snapshot;

        public SnapshotArrayIterator(ArrayList<E> arrayList) {
            this.cursor = 0;
            this.snapshot = new ArrayList<>();
            this.snapshot.addAll(arrayList);
        }

        @Override
        public boolean hasNext() {
            return cursor < snapshot.size();
        }

        @Override
        public E next() {
            E currentItem = snapshot.get(cursor);
            cursor++;
            return currentItem;
        }
    }
}
