package com.example.learnofthread.gaoji;


import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 t = new TestLock2();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}


class TestLock2 implements Runnable {
    int tickNum = 10;

    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true) {
            if(tickNum>0){

                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println(tickNum--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }else {
                break;
            }
        }
    }
}
