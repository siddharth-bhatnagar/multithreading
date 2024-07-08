package com.quantum.learning.solid;

public class InterfaceSegmentationPrinciple {
    // Interfaces should be such that clients should not have to implement unnecessary methods which they don't need.

    interface RestaurantEmployee {
        void cookFood();
        void takeOrder();
        void cleanKitchen();
        void serveFood();
    }

    class Waiter1 implements RestaurantEmployee {

        @Override
        public void cookFood() {
            // not needed
        }

        @Override
        public void takeOrder() {

        }

        @Override
        public void cleanKitchen() {
            // not needed
        }

        @Override
        public void serveFood() {

        }
    }

    interface WaiterInterface {
        void takeOrder();
        void serveOrder();
    }

    interface ChefInterface {
        void cleanKitchen();
        void cookFood();
    }

    class Waiter2 implements WaiterInterface {

        @Override
        public void takeOrder() {

        }

        @Override
        public void serveOrder() {

        }
    }

    class Chef2 implements ChefInterface {

        @Override
        public void cleanKitchen() {

        }

        @Override
        public void cookFood() {

        }
    }
}
