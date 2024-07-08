package com.quantum.learning.designPatterns.decoratorPattern;

public class Mushroom extends ToppingDecorator {
    private BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    double cost() {
        return this.basePizza.cost() + 79.99;
    }
}
