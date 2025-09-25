package com.example.learnofthread;


public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}

class Player extends Thread {
     TV tv;
     public Player(TV tv) {
         this.tv = tv;
     }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                try {
                    this.tv.play("电视据播放");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    this.tv.play("抖音");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Watcher extends Thread {
   TV tv;
   public Watcher(TV tv) {
       this.tv = tv;
   }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TV {

    // 演员表演时观众等待
    String voice;
    boolean flag = true;

    // 表演
    public synchronized void play(String voice) throws InterruptedException {

        if(!flag){
            this.wait();
        }
        System.out.println("演员表演了"+voice);

        // 通知
        this.notifyAll();


        this.voice = voice;

        this.flag = !this.flag;

    }
    // 观看

    public synchronized void watch() throws InterruptedException {

        if(flag) {
            this.wait();
        }

        System.out.println("观众观看了"+voice);

        this.notifyAll();
        this.flag = !this.flag;
    }
}