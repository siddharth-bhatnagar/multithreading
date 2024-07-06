package com.quantum.learning.designPatterns;

public class Singleton {

    private static volatile Singleton singletonInstance = null;

    private Singleton() {
        System.out.println("Singleton Instance created");
    }

    public static Singleton getSingletonInstance() {
        if (singletonInstance == null) {
            synchronized (Singleton.class) {
                if (singletonInstance == null) {
                    singletonInstance = new Singleton();
                }
            }
        }

        return singletonInstance;
    }

}
