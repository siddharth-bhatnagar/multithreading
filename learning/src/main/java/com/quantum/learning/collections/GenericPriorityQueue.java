package com.quantum.learning.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GenericPriorityQueue <T> {

    private List<T> q;

    public GenericPriorityQueue() {
        q = new ArrayList<>();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int size() {
        return q.size();
    }

    public boolean offer(T t) {
        q.add(t);
        upheapify(q.size() - 1);
        return true;
    }

    public T peek() {
        if (q.isEmpty()) return null;
        return q.get(0);
    }

    public T poll() {
        if (q.isEmpty()) return null;
        swap(0, q.size() - 1);
        T element = q.removeLast();
        downheapify();
        return element;
    }

    private void upheapify(int i) {
        int pi = (i - 1) / 2;

        T pe = q.get(pi);
        T ce = q.get(i);

        while (i != 0 && )
    }

    private void downheapify() {

    }

    private void swap(int i, int j) {
        T temp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, temp);
    }
}
