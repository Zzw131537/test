package com.example.learnofannocation.demos.web.example;




import java.io.IOException;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class e3 {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();
        Scanner scanner = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;

        while(flag) {
            if(scanner.hasNext()) {
                String trim = scanner.next().trim();
                if(Objects.equals(trim,"byebye")) {
                    out.println("byebye");
                    flag=false;
                }else {
                    out.println("echo: "+trim);
                }
            }
        }
        scanner.close();
        out.close();
        client.close();
        server.close();

    }
}
