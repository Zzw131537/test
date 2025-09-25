package com.example.learnofthread;

// 测试线程优先级
public class TestPriotrity{
     // 主线程优先级
     public static void main(String[] args) {
         System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

         MyThread1 t1=new MyThread1();

         Thread t2=new Thread(t1);
         Thread t3=new Thread(t2);
         Thread t4=new Thread(t3);

         t2.start();

         t3.setPriority(2);
         t3.start();
         t4.setPriority(Thread.MAX_PRIORITY);
         t4.start();


     }
}

 class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
    }
}