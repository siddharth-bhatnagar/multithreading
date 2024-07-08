package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class BikeEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Bike Engine is runnning.");
    }
}
