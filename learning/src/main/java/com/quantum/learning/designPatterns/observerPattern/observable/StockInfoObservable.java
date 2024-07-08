package com.quantum.learning.designPatterns.observerPattern.observable;

import com.quantum.learning.designPatterns.observerPattern.observer.NotificationAlertObserver;

public interface StockInfoObservable {
    void addObserver(NotificationAlertObserver observer);
    void removeObserver(NotificationAlertObserver observer);
    void notifySubscribers();
    int getStockCount();
    void setStockCount(int stockCount);
}
