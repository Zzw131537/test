package com.example.learnofannocation.demos.web;


import java.lang.annotation.*;

@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}

// 表示注解可以用在哪些地方
@Target(value ={ElementType.METHOD,ElementType.TYPE} )
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}