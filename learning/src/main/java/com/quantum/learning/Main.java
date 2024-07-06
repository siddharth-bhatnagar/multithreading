package com.quantum.learning;

import com.quantum.learning.threads.Stack;
import com.quantum.learning.threads.Thread1;
import com.quantum.learning.threads.Thread2;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread started");
//        Thread thread1 = new Thread1("thread1");
//        thread1.setDaemon(false);
//        thread1.start();
//
//        Thread thread2 = new Thread(new Thread2(), "thread2");
//        thread2.start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + ", i: " + i);
//            }
//        }, "thread3").start();

//        Stack<Integer> stack = new Stack<>();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + " thread started");
//
//            while (!stack.isEmpty()) {
//                System.out.println(stack.pop());
//            }
//        }, "thread5").start();

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

//        new Thread(() -> {
//
//            System.out.println(Thread.currentThread().getName() + " thread started");
//
//            int counter = 1;
//            while (counter < 10) {
//                stack.push(counter);
//                counter++;
//            }
//        }, "thread4").start();
//
//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                for (int i = 0; i < 1000; i++);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "thread6");
//
//        t.start();
//
//        while (true) {
//            Thread.State state = t.getState();
//            System.out.println(state);
//            if (state == Thread.State.TERMINATED) {
//                break;
//            }
//        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread: " + i);
            }
        }, "thread7");

//        thread.start();
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        // Deadlock

        String lock1 = "Siddharth";
        String lock2 = "Bhatnagar";

        Thread myThread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                }
            }
        }, "thread8");

        Thread myThread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                }
            }
        }, "thread9");

        myThread1.start();
        myThread2.start();

        System.out.println(Thread.currentThread().getName() + " thread ended");
    }
}
