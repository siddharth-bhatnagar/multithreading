package com.quantum.learning.solid;

public class InvoiceDao {

    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public boolean saveDB() {
        // some logic
        return true;
    }

// Violates open/closed principle
//    public boolean saveToFile() {
//        // some logic
//        return true;
//    }
}

// Open/Closed Principle -> Classes should be open for extension but closed for modification.