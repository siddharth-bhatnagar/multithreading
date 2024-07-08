package com.quantum.learning.designPatterns.decoratorPattern;

public class RedPaprika extends BasePizza {

    private BasePizza basePizza;

    public RedPaprika(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    double cost() {
        return this.basePizza.cost() + 49.99;
    }
}
