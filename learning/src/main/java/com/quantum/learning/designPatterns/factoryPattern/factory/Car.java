package com.quantum.learning.designPatterns.factoryPattern.factory;

public class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}
