package com.example.learnofthread;


public class StaticProxy {
    public static void main(String[] args) {

        WeddingCompany weddingCompany=new WeddingCompany(new You());

        weddingCompany.happyMarry();

    }
}

interface Marry{


    void happyMarry();

}

// 真实角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("Zhouzw 要结婚了");
    }
}

// 代理角色
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    private void before() {
        System.out.println("布置现场");
    }

    private void after() {
        System.out.println("收尾款");
    }

    @Override
    public void happyMarry() {
        before();
       this.target.happyMarry();
       after();
    }
}
