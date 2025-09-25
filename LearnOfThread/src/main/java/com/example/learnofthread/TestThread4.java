package com.example.learnofthread;


// 多个线程操作同一个对象
public class TestThread4 implements Runnable{

    private int ticketNum = 10;

    @Override
    public void run() {
       while (true) {
           if(ticketNum<=0){
               break;
           }
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum+"票");
           ticketNum--;
       }
    }


    // 多个线程操作同一个资源下数据不安全
    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"小米").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
        new Thread(ticket,"黄牛2").start();

    }
}
