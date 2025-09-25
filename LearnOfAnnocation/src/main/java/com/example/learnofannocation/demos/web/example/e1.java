package com.example.learnofannocation.demos.web.example;


import java.lang.reflect.Array;
import java.util.Arrays;

class Book implements  Comparable<Book>{

    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名："+this.title+"价格"+this.price+"\n";
    }

    @Override
    public int compareTo(Book o) {

        if(this.price < o.price) {
            return -1;
        }else {
            return 0;
        }
    }
}

public class e1 {
    public static void main(String[] args) {
        Book books []= new Book[] {
                new Book("Java开发实战经典",79.8),
                new Book("JavaWEB开发实战经典",69.8),
                new Book("Oracle开发实战经典",99.8),
                new Book("Android开发实战经典",89.8)
        };
        Arrays.sort(books);

        System.out.println(Arrays.toString(books));
    }
}
