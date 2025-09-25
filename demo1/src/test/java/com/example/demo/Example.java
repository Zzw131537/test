package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.sun.tools.javac.util.StringUtils;
import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("123");
        book.setTitle("abc");
        String jsonString = JSON.toJSONString(book);
        System.out.println(jsonString);
        Map<String,Integer>  a= new HashMap<>();

    }
}
