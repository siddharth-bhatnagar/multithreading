package com.quantum.learning.designPatterns.factoryPattern;

import com.quantum.learning.designPatterns.factoryPattern.abstractFactory.BikeFactory;
import com.quantum.learning.designPatterns.factoryPattern.abstractFactory.CarFactory;
import com.quantum.learning.designPatterns.factoryPattern.abstractFactory.VehicleFactory2;
import com.quantum.learning.designPatterns.factoryPattern.factory.Vehicle;
import com.quantum.learning.designPatterns.factoryPattern.factory.VehicleFactory;

public class Factory {
    public static void run() {
        // Factory Pattern - Used to create objects at runtime when type is not known before hand.
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle1 = factory.getVehicle("CAR");
        vehicle1.drive();

        Vehicle vehicle2 = factory.getVehicle("BIKE");
        vehicle2.drive();


        // Abstract Factory Pattern - Used to create family of related objects.

        VehicleFactory2 vehicleFactory = new CarFactory();
        VehicleFactory2 vehicleFactory2 = new BikeFactory();

        vehicleFactory.createVehicle().drive();
        vehicleFactory2.createVehicle().drive();

        vehicleFactory2.createEngine().start();
        vehicleFactory.createEngine().start();
    }
}
