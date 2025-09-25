package com.example.learnofmybatis.base.Thread;


import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        Socket clien = new Socket("localhost", 9999);

        Scanner scanner = new Scanner(clien.getInputStream());
        scanner.useDelimiter("\n");

        if(scanner.hasNext()) {
            System.out.println("【回应数据】 "+scanner.next());
        }
        scanner.close();
        clien.close();
    }
}
