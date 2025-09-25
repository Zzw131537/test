package com.example.learnofthread;


import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestThread2 extends Thread {

    private String url,name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoad webDownLoad = new WebDownLoad();
        try {
            webDownLoad.download(url,name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("下载的文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F1127%2F397789afj00snm6cn000ad000hs00hsm.jpg&thumbnail=660x2147483647&quality=80&type=jpg","图片1.jpg");
        TestThread2 t2=new TestThread2("https://ww1.sinaimg.cn/mw690/006w6EJvly1hpp5yzpnj8j30mn14a78h.jpg","图片2.jpg");
        TestThread2 t3 =new TestThread2("https://img2.baidu.com/it/u=3192883876,84643790&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=800","图片3.jpg");

        t1.start();

        t2.start();
        t3.start();
    }
}

class WebDownLoad {
    public  void download(String url,String name) throws IOException {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("出现异常");
        }

    }
}
