package com.quantum.learning.solid;

public class Invoice {

    private Marker marker;
    private int qty;

    public Invoice(Marker marker, int qty) {
        this.marker = marker;
        this.qty = qty;
    }

    public int calculateCost() {
        return marker.getPrice() * qty;
    }

//    violates single responsibility principle
//    public boolean saveDB() {
//        // some logic
//        return true;
//    }
}

// Single Responsibility Principle -> A class should have only single reason to change.