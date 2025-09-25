package com.example.learnofannocation.demos.web.example;


import java.util.Locale;

class MyThread implements  Runnable {
    private int ticket = 60;

    @Override
    public void run() {
        for(int x=0;x<20;x++){
            try {
                this.sale();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void sale() throws InterruptedException {
        if(this.ticket > 0){
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName()+"ticket: "+ticket);
            this.ticket--;
        }
    }
}
public class ex2 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"窗口A").start();
        new Thread(mt,"窗口B").start();
        new Thread(mt,"窗口C").start();
        new Thread(mt,"窗口D").start();


    }
}
