package com.example.learnofannocation.demos.web;


public class Test06 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A {

    static {
        System.out.println("A 类代码块初始化");
        m=300;
    }
    static int m=100;
    public A() {

    }
}
