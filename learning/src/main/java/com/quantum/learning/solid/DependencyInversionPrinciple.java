package com.quantum.learning.solid;

public class DependencyInversionPrinciple {
    // Classes should depend on interfaces rather than concrete classes.

    interface Keyboard {

    }

    interface Mouse {

    }

    class WiredKeyboard implements Keyboard {}

    class WirelessKeyboard implements Keyboard {}

    class WirelessMouse implements Mouse {}

    class WiredMouse implements Mouse {}

    // violates dependency Inversion principle
    class Macbook {
        private final WiredKeyboard keyboard;
        private final WirelessMouse mouse;

        public Macbook() {
            this.keyboard = new WiredKeyboard();
            this.mouse = new WirelessMouse();
        }
    }

    class Macbook1 {
        private final Keyboard keyboard;
        private final Mouse mouse;

        public Macbook1(Keyboard keyboard, Mouse mouse) {
            this.keyboard = keyboard;
            this.mouse = mouse;
        }
    }
}
