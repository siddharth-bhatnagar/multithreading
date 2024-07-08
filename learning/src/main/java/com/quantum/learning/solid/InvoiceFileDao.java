package com.quantum.learning.solid;

public class InvoiceFileDao implements InvoiceDaoInterface {

    @Override
    public boolean save() {
        // save to file.
        return false;
    }
}

// Adheres to open/closed principle.