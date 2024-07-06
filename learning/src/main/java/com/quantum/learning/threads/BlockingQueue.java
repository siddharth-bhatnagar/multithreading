package com.quantum.learning.threads;

import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * Java's Object class provides the implementation of the methods
 *
 * wait()
 * notify()
 * notifyAll()
 *
 */
public class BlockingQueue <T> {

    private final Queue<T> queue;
    private final Integer capacity;

    public BlockingQueue(final Integer capacity) {
        this.queue = new LinkedList<T>();
        this.capacity = capacity;
    }

    public BlockingQueue() {
        this.capacity = 5;
        this.queue = new LinkedList<>();
    }

    public boolean add(T item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.offer(item);
            queue.notifyAll();

            return true;
        }
    }

    public T remove() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T result = queue.poll();
            queue.notifyAll();

            return result;
        }
    }
}


