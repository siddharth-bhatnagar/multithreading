package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class CarEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Car Engine is running");
    }
}
