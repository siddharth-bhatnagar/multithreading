package com.quantum.learning.designPatterns.strategyPattern.without;

public class SportsVehicle extends Vehicle {

    @Override
    public void drive() {
        System.out.println("Special drive strategy");
    }
}
