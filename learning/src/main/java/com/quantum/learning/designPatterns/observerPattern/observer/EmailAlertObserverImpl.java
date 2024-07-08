package com.quantum.learning.designPatterns.observerPattern.observer;

import com.quantum.learning.designPatterns.observerPattern.observable.StockInfoObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    private StockInfoObservable stockInfoObservable;
    private String email;

    public EmailAlertObserverImpl(String email, StockInfoObservable stockInfoObservable) {
        this.email = email;
        this.stockInfoObservable = stockInfoObservable;
        stockInfoObservable.addObserver(this);
    }

    @Override
    public void update() {
        sendEmail(email, "Product is in stock, please hurry up!");
    }

    private void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email);
        System.out.println("Message: " + message);

        // Sending Email logic.
    }
}
