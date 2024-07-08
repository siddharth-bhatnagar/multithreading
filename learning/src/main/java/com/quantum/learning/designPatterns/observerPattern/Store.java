package com.quantum.learning.designPatterns.observerPattern;

import com.quantum.learning.designPatterns.observerPattern.observable.IphoneStockInfoObservableImpl;
import com.quantum.learning.designPatterns.observerPattern.observable.StockInfoObservable;
import com.quantum.learning.designPatterns.observerPattern.observer.EmailAlertObserverImpl;
import com.quantum.learning.designPatterns.observerPattern.observer.MobileAlertObserverImpl;
import com.quantum.learning.designPatterns.observerPattern.observer.NotificationAlertObserver;

public class Store {
    public static void run() {

        StockInfoObservable iphoneObservable = new IphoneStockInfoObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("siddharth@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("siddharthxone@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("siddharthxone", iphoneObservable);

        iphoneObservable.setStockCount(10);
        iphoneObservable.setStockCount(0);
        iphoneObservable.setStockCount(5);
    }
}
