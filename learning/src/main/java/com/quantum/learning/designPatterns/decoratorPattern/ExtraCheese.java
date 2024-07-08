package com.quantum.learning.designPatterns.decoratorPattern;

public class ExtraCheese extends ToppingDecorator {
    private BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    double cost() {
        return this.basePizza.cost() + 9.99;
    }
}
