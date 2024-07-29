package com.quantum.learning;//package com.quantum.learning;
//
//import com.quantum.learning.collections.Run;
//import com.quantum.learning.designPatterns.decoratorPattern.PizzaShop;
//import com.quantum.learning.designPatterns.factoryPattern.Factory;
//import com.quantum.learning.designPatterns.observerPattern.Store;
//import com.quantum.learning.oa.Process;
//import com.quantum.learning.threads.Stack;
//import com.quantum.learning.threads.Thread1;
//import com.quantum.learning.threads.Thread2;
//
//public class Main {
//
//    public static void main(String[] args) {
////        System.out.println(Thread.currentThread().getName() + " thread started");
////        Thread thread1 = new Thread1("thread1");
////        thread1.setDaemon(false);
////        thread1.start();
////
////        Thread thread2 = new Thread(new Thread2(), "thread2");
////        thread2.start();
////
////        new Thread(() -> {
////            for (int i = 0; i < 10; i++) {
////                System.out.println(Thread.currentThread().getName() + ", i: " + i);
////            }
////        }, "thread3").start();
//
////        Stack<Integer> stack = new Stack<>();
////
////        stack.push(1);
////        stack.push(2);
////        stack.push(3);
////        stack.push(4);
////        stack.push(5);
////
////        new Thread(() -> {
////            System.out.println(Thread.currentThread().getName() + " thread started");
////
////            while (!stack.isEmpty()) {
////                System.out.println(stack.pop());
////            }
////        }, "thread5").start();
//
////        while (!stack.isEmpty()) {
////            System.out.println(stack.pop());
////        }
//
////        new Thread(() -> {
////
////            System.out.println(Thread.currentThread().getName() + " thread started");
////
////            int counter = 1;
////            while (counter < 10) {
////                stack.push(counter);
////                counter++;
////            }
////        }, "thread4").start();
////
////        Thread t = new Thread(() -> {
////            try {
////                Thread.sleep(1);
////                for (int i = 0; i < 1000; i++);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        }, "thread6");
////
////        t.start();
////
////        while (true) {
////            Thread.State state = t.getState();
////            System.out.println(state);
////            if (state == Thread.State.TERMINATED) {
////                break;
////            }
////        }
//
////        Thread thread = new Thread(() -> {
////            for (int i = 0; i < 10; i++) {
////                System.out.println("Thread: " + i);
////            }
////        }, "thread7");
//
////        thread.start();
////
////        try {
////            thread.join();
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//
//
//        // Deadlock
//
////        String lock1 = "Siddharth";
////        String lock2 = "Bhatnagar";
////
////        Thread myThread1 = new Thread(() -> {
////            synchronized (lock1) {
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
////                }
////                synchronized (lock2) {
////                    System.out.println("Thread: " + Thread.currentThread().getName());
////                }
////            }
////        }, "thread8");
////
////        Thread myThread2 = new Thread(() -> {
////            synchronized (lock2) {
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
////                }
////                synchronized (lock1) {
////                    System.out.println("Thread: " + Thread.currentThread().getName());
////                }
////            }
////        }, "thread9");
////
////        myThread1.start();
////        myThread2.start();
////
////        System.out.println(Thread.currentThread().getName() + " thread ended");
//
////        Store.run();
////        PizzaShop.run();
////        Factory.run();
////        Run.execute();
//        Process.run();
//    }
//}
//

import java.util.*;

public class Main {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void dfs(int node, int parent, int mask, char[] A, List<List<Integer>> adj, int[] ans, Map<Integer, Integer> mp) {
        int cnt = 0;
        char ch = A[node];
        int req_mask = (1 << (ch - 'a')) ^ mask;

        cnt += mp.getOrDefault(req_mask, 0);
        for (int i = 0; i < 26; i++) {
            int another_possible_mask = req_mask ^ (1 << i);
            cnt += mp.getOrDefault(another_possible_mask, 0);
        }
        ans[node] = cnt;

        mp.put(req_mask, mp.getOrDefault(req_mask, 0) + 1);
        for (int x : adj.get(node)) {
            if (x != parent) {
                dfs(x, node, req_mask, A, adj, ans, mp);
            }
        }
        mp.put(req_mask, mp.get(req_mask) - 1);
        if (mp.get(req_mask) == 0) mp.remove(req_mask);
    }

    static int[] solution(int tree_nodes, char[] A, int[] tree_from, int[] tree_to, int[] q) {
        List<List<Integer>> adj = new ArrayList<>(tree_nodes);
        for (int i = 0; i < tree_nodes; i++) {
            adj.add(new ArrayList<>());
        }
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[tree_nodes];

        for (int i = 0; i < tree_from.length; i++) {
            adj.get(tree_from[i]).add(tree_to[i]);
            adj.get(tree_to[i]).add(tree_from[i]);
        }

        mp.put(0, 1);
        dfs(0, -1, 0, A, adj, ans, mp);

        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            res[i] = ans[q[i]];
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int tree_nodes = scanner.nextInt();
//
//        char[] A = new char[tree_nodes];
//        for (int i = 0; i < tree_nodes; i++) {
//            A[i] = scanner.next().charAt(0);
//        }
//
//        int[] tree_from = new int[tree_nodes - 1];
//        int[] tree_to = new int[tree_nodes - 1];
//        for (int i = 0; i < tree_nodes - 1; i++) {
//            tree_from[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < tree_nodes - 1; i++) {
//            tree_to[i] = scanner.nextInt();
//        }
//
//        int m = scanner.nextInt();
//        int[] q = new int[m];
//        for (int i = 0; i < m; i++) {
//            q[i] = scanner.nextInt();
//        }

        char[] A = new char[]{'a','b','b','b','a','c','a','a','c'};
        int a[] = new int[]{0,0,1,2,2,3,3,4};
        int b[] = new int[]{1,2,8,3,4,5,6,7};
        int m=9;
        int q[] = new int[]{0,1,2,3,4,5,6,7,8};
        int[] res = solution(9, A, a, b, q);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
