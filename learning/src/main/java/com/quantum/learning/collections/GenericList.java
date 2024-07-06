package com.quantum.learning.collections;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {

    private final T[] items;
    private int size;

    public GenericList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void addItem(T item) {
        items[size++] = item;
    }

    public T getItem(int index) {
        return items[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new GenericListIterator<>(this);
    }

    private class GenericListIterator<T> implements Iterator<T> {

        private int index;
        private GenericList<T> list;

        public GenericListIterator(GenericList<T> list) {
            this.list = list;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < list.size;
        }

        @Override
        public T next() {
            return list.getItem(index++);
        }
    }
}
