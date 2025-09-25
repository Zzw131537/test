package com.example.learnofmybatis.base.Thread;


import org.eclipse.jetty.util.thread.Locker;

import javax.sound.sampled.FloatControl;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyCounter {
    private int count = 0;

    public  synchronized void add(int value) {
        this.count +=value;
    }

    public synchronized void subtrac(int value) {
        this.count-=value;
    }
}

class MyRunnable implements  Runnable {
    private ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal1.set((int) (Math.random()*100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadLocal1.get());
    }
}

class MySignal {
    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess() {
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
public class T1 {





    public static void main(String[] args) throws InterruptedException {
       MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();



    }
}
