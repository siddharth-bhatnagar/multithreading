package com.quantum.learning.designPatterns.decoratorPattern;

public abstract class BasePizza {
    abstract double cost();
}

/**
 * Decorator pattern is used to solve the problem of class explosion.
 * Let's say you have a base pizza and then you all different kinds of toppings which you
 * can use to top your pizza off. We can implement this but we will have to write classes for all permutations
 * and combinations of toppings and pizzas as you can pair your base pizza with some topping, and those toppings with
 * other other toppings.
 *
 * Decorator pattern solves this by having only one class for each pizza topping and base pizza types. Then we can wrap
 * our objects with N number of outer objects which represent the toppings.
 *
 * This is done as the topping a.k.a new feature maintains both is-a and has-a relationship with the base object.
 */
