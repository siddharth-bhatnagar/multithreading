package com.quantum.learning.designPatterns.observerPattern.observable;

import com.quantum.learning.designPatterns.observerPattern.observer.NotificationAlertObserver;
import java.util.ArrayList;
import java.util.List;

public class IphoneStockInfoObservableImpl implements StockInfoObservable {

    private List<NotificationAlertObserver> observers = new ArrayList<>();
    private int stockCount = 0;

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer: observers) {
            observer.update();
        }
    }

    public void setStockCount(int stockCount) {
        if (stockCount == 0) {
            this.notifySubscribers();
        }
        this.stockCount = stockCount;
    }

    public int getStockCount() {
        return stockCount;
    }
}
