package com.example.learnofannocation.demos.web.example;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e6 {

    ReentrantLock lock = new ReentrantLock();

    void test() {
        lock.lock();
        try{
            System.out.println("test");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {



    }
}
