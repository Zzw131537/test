package com.example.learnofmybatis.base.Thread;


public class T2 {
    private int cnt=0;
    private void add10K() {
        for(int i=0;i<10000;i++){
            this.cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T2 t3 = new T2();
        Thread t1=new Thread(()->{
            t3.add10K();
        });
        Thread t2=new Thread(()->{
             t3.add10K();
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(t3.cnt);
    }
}
