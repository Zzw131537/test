package com.example.learnofmybatis.base.Thread;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket client = serverSocket.accept();

        Scanner scanner = new Scanner(client.getInputStream());
        PrintStream printStream = new PrintStream(client.getOutputStream());

        boolean flag = true;

        while(flag) {
            if(scanner.hasNext()) {
                String trim = scanner.next().trim();
                if(trim.equalsIgnoreCase("byebye")) {
                    printStream.println("byebye");
                    flag = false;
                }else {
                    printStream.println("ECHO " + trim);
                }
            }
        }
        scanner.close();
        printStream.close();
        client.close();
        serverSocket.close();
    }
}
