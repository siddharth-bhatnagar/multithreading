package com.quantum.learning.designPatterns.strategyPattern.with;

public class NormalVehicle extends Vehicle {

    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }

    public NormalVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
