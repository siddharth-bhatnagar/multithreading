package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Car");
    }
}
