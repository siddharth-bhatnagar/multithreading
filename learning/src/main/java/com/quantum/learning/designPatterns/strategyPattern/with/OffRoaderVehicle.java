package com.quantum.learning.designPatterns.strategyPattern.with;

public class OffRoaderVehicle extends Vehicle {

    public OffRoaderVehicle() {
        super(new SpecialDriveStrategy());
    }

    public OffRoaderVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
