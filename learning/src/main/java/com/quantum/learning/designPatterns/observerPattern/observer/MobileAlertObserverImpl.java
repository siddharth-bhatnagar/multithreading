package com.quantum.learning.designPatterns.observerPattern.observer;

import com.quantum.learning.designPatterns.observerPattern.observable.StockInfoObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    private StockInfoObservable observable;
    private String userName;

    public MobileAlertObserverImpl(String userName, StockInfoObservable observable) {
        this.observable = observable;
        this.userName = userName;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        sendMessage(userName, "Product is in stock, please hurry up!");
    }

    public void sendMessage(String userName, String message) {
        System.out.println(userName + ": " + message);
    }
}
