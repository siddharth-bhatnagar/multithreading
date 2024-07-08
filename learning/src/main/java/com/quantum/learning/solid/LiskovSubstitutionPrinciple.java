package com.quantum.learning.solid;

public class LiskovSubstitutionPrinciple {

    // If class B is a subclass of class A, then we should be able to replace object of A with object of B without
    // breaking the behavior of the program.

    interface Bike {
        void turnOnEngine();
        void accelerate();
    }

    class Motorcyle implements Bike {

        private boolean engineTurnedOn = false;
        private int speed = 0;

        @Override
        public void turnOnEngine() {
            engineTurnedOn = true;
        }

        @Override
        public void accelerate() {
            this.speed += 10;
        }
    }

    // violates liskov substitution
    // subclass should only add the functionality of parent class, not narrow it down.
    class Bicycle implements Bike {
        private int speed = 0;


        @Override
        public void turnOnEngine() {
            throw new RuntimeException("Engine is not present in a cycle.");
        }

        @Override
        public void accelerate() {
            this.speed += 5;
        }
    }


    Bike bike = new Motorcyle();
}
