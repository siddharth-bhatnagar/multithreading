package com.quantum.learning.threads;

public class Stack <T> {
    private T[] array;
    private int top;
    private Object lock;

    public Stack() {
        array = (T[]) new Object[10];
        top = -1;
        lock = new Object();
    }

    public Stack(int capacity) {
        array = (T[]) new Object[capacity];
        top = -1;
        lock = new Object();
    }

    public synchronized void push(T item) {
        if (top == array.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        array[++top] = item;
    }

    public T pop() {
        synchronized (this) {
            if (top == -1) {
                throw new RuntimeException("Stack Underflow");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return array[top--];
        }
    }

    public T peek() {
        if (top == -1) {
            throw new RuntimeException("Stack Underflow");
        }

        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void hello() {
        synchronized (Stack.class) {
            System.out.println("hello");
        }
    }
}
