package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
        Collection<String> all = new ArrayList<>();

        System.gc();

        all.add("hello");
        all.add("world");
        for (String s : all) {
            System.out.println(s);
        }
    }

}
