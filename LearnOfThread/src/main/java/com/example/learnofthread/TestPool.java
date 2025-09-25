package com.example.learnofthread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        
        service.execute(new MyThread());
        
        service.execute(new MyThread());
        service.execute(new MyThread());
        
        service.shutdown();
    }
}



class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}