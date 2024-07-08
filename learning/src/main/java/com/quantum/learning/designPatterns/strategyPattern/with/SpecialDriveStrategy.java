package com.quantum.learning.designPatterns.strategyPattern.with;

public class SpecialDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Special Drive Strategy");
    }
}
