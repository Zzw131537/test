package com.example.demo;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
public class Book {
    private String title;
    private String author;

    static public int count = 18;

    public static void main(String[] args) {
//        Book book = new Book();
//
//        System.out.println(Book.count);
//
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> sq = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
//        System.out.println(sq.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }
}


