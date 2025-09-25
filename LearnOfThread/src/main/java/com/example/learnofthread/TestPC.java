package com.example.learnofthread;


// 测试生产消费模型，利用缓冲区解决
public class TestPC {
    public static void main(String[] args) {
        SynContatiner synContatiner = new SynContatiner();
        new Prodctor(synContatiner).start();
        new Consumer(synContatiner).start();
    }
}

class Prodctor extends Thread {
    SynContatiner synContatiner;

    public Prodctor(SynContatiner synContatiner) {
        this.synContatiner = synContatiner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("生产了"+i+"只鸡");
            try {
                synContatiner.Push(new Chicken(i));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {
    SynContatiner synContatiner;
    public Consumer(SynContatiner synContatiner) {
        this.synContatiner = synContatiner;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            Chicken chicken = null;
            try {
                chicken = synContatiner.Pop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("消费了"+chicken.id+"只鸡");

        }
    }
}

class Chicken {
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}

class SynContatiner{
    Chicken[] chickens=new Chicken[10];
    int cont=0;
    // 生产
    public synchronized void Push(Chicken chicken) throws InterruptedException {
        if(cont == chickens.length || cont <= 0){
            this.wait();
        }

        chickens[cont] = chicken;

        cont++;


    }


    // 消费
    public synchronized Chicken Pop() throws InterruptedException {

        if(cont==0){
             this.wait();
        }

        cont--;
        Chicken chicken=chickens[cont];
        return chicken;
    }
}
