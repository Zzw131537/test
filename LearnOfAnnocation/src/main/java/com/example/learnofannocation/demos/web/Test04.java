package com.example.learnofannocation.demos.web;


import lombok.Data;

// 反射
public class Test04 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {

        Class c1 = Class.forName("com.example.learnofannocation.demos.web.User");


        System.out.println(c1);

    }
}

@Data
class User{
    private String name;
    private int age;
    private int id;

}
