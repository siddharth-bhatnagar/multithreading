package com.quantum.learning.designPatterns.decoratorPattern;

public class PizzaShop {

    public static void run() {
        BasePizza myPizza = new Mushroom(
                new RedPaprika(
                        new ExtraCheese(
                                new IndieTandooriPaneer()
                        )
                )
        );

        System.out.println("Total Cost of Pizza: " + myPizza.cost());
    }
}
