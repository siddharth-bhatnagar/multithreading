package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving Bike...");
    }
}
