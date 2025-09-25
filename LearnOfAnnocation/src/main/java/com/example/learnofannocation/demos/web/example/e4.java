package com.example.learnofannocation.demos.web.example;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class e4 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(client.getInputStream());
        PrintStream printStream = new PrintStream(client.getOutputStream());
        scanner.useDelimiter("\n");
        scanner1.useDelimiter("\n");
        boolean flag = true;
        while(flag) {
            System.out.println("发送数据");
            if (scanner.hasNext()) {
                String trim = scanner.next().trim();
                printStream.println(trim);
                if(Objects.equals(trim,"byebye")) {
                    flag = true;;
                }
                System.out.println(scanner1.next());

            }

        }
        scanner.close();
        client.close();
        printStream.close();
        scanner1.close();
    }
}
