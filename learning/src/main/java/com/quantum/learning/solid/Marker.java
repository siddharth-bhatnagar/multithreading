package com.quantum.learning.solid;

public class Marker {
    private String color;
    private int price;

    public Marker(String color, int price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
