package com.quantum.learning.designPatterns.strategyPattern.with;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
