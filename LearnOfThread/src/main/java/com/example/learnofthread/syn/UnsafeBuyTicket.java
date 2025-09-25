package com.example.learnofthread.syn;


public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket t1 = new BuyTicket();

        new Thread(t1,"K1").start();
        new Thread(t1,"K2").start();
        new Thread(t1,"k3").start();
    }
}


class  BuyTicket implements Runnable{

    private static int ticket = 10;

    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            buy();
        }
    }

    private synchronized void buy() {
       if(ticket < 0) {
           return ;
       }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticket--);
    }
}