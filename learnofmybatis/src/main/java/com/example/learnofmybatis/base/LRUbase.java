package com.example.learnofmybatis.base;

// LRU 最近最少使用
//实现两个方法 get(key)  put(key)

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUbase {

    class Node {
        int key,value;
        Node prev,next;
        Node(int k,int v) {
            this.key=k;
            this.value=v;
        }
    }

    private int capacity;
    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node(0,0),tail = new Node(0,0);

    public LRUbase(int capacity) {
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node =map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        if(map.size() == capacity) remove(tail.prev);
        insert(new Node(key,value));
    }
    private void insert (Node node) {
        map.put(node.key,node);
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        for (int i=0;i<10;i++) {
            new Thread(""+i){
                @Override
                public void run() {
                    System.out.println("Thread : "+getName()+"running");
                }
            }.start();
        }
        System.out.println("------------------------------------------------------");
        System.out.println();

        Myrunnnable runnable = new Myrunnnable();
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(10L*1000L);
        runnable.doStop();

    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("my thread running");
    }
}

class Myrunnnable implements  Runnable{

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop=true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop==false;
    }

    @Override
    public void run() {

        while(keepRunning()) {
            System.out.println("running");

            try {
                Thread.sleep(3L*100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}






