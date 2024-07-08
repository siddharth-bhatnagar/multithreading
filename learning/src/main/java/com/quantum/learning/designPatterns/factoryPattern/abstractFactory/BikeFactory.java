package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class BikeFactory implements VehicleFactory2 {

    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }

    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }
}