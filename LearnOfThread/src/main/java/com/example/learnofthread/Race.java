package com.example.learnofthread;


// 模拟龟兔赛跑
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            boolean flag = gameOver(i);
            if (flag) {
                break; // 比赛结束，停止
            }else {
                System.out.println(Thread.currentThread().getName()+"-----> 跑了"+i+"步");
            }

        }
    }
    private boolean gameOver(int step){
        if(winner != null ){
            return true;
        }else {
            if (step>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
