package com.example.learnofannocation.demos.web;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class test03 {
    @MyAnnotation1(name = "Zhouzw")
    public void test() {

    }
}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {

    String name();

}
