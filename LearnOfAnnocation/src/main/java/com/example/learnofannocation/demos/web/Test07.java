package com.example.learnofannocation.demos.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test07 {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("t1");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3");
        });
        t3.start();
        t1.start();
        t2.start();

        t1.interrupt();
        List<Integer> a = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> b = new ArrayList<>();
        Object[] c = b.toArray();

    }
}
