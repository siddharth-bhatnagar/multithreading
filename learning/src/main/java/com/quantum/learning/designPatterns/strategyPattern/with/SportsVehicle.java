package com.quantum.learning.designPatterns.strategyPattern.with;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SpecialDriveStrategy());
    }

    public SportsVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
