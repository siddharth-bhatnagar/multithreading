package com.quantum.learning.designPatterns.factoryPattern.abstractFactory;

public class CarFactory implements VehicleFactory2 {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }
}
