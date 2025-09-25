package com.example.learnofannocation.demos.web;

class animal {
    private int weight;

    public void move() {
        System.out.println("animal move");
    }

    public void sleep() {
        System.out.println("animal sleepping");
    }
}

class fish extends animal {

    @Override
    public void move() {
        System.out.println("swimming");
    }
}

class bird extends animal {
    @Override
    public void move() {
        System.out.println("flying");
    }
}

public class Test08 {

    public static void main(String[] args) {
        animal a = new bird();
        animal b = new fish();
        a.move();
        a.sleep();
        b.sleep();
        b.move();
    }
}
