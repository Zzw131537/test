package com.example.learnofthread;


// 继承Thread 重写run方法，调用start 开启线程

public class TestThread3 implements Runnable {

    @Override
    public void run() {

        for(int i=0;i<20;i++){
            System.out.println("我在看代码....."+i);
        }
    }

    public static void main(String[] args) {
        TestThread3 t1 = new TestThread3();
        Thread t2 = new Thread(t1);

        t2.start();
        for(int i=0;i<20;i++){
            System.out.println("我在学习...");
        }
    }
}
