package com.example.learnofthread;


public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin t = new TestJoin();
        Thread t1 = new Thread(t);
        t1.start();

        for(int i=0;i<500;i++){
            if(i==200){
                t1.join();
            }
            System.out.println("main"+i);
        }
    }
}
