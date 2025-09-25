package com.example.learnofthread;


// 观察线程状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()-> {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(2000); // 进入阻塞状态
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        });

        Thread.State state = t1.getState();
        System.out.println(state);

        t1.start();
        state = t1.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){
           Thread.sleep(100);
           state = t1.getState();
            System.out.println(state);
        }
    }
}
