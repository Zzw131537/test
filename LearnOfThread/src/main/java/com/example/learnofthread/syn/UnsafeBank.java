package com.example.learnofthread.syn;



// 不安全取钱
public class UnsafeBank {

    Account account = new Account(100,"基金");

    Drawing you = new Drawing(account,50,"你");

    Drawing you2 = new Drawing(account,50,"you2");

}

class Account  {
    int money ;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account; // 账户
    // 取了多少
    int deawingmoney;

    int nowMoney;

    public Drawing(Account account, int deawingmoney, String name) {
        this.account = account;
        this.deawingmoney = deawingmoney;
        this.nowMoney = nowMoney;
    }

    @Override
    public void run() {
        // 判断有没有钱
        if (account.money-this.deawingmoney < 0) {
            System.out.println(Thread.currentThread().getName()+"钱不够");
        }

        account.money =account.money-deawingmoney;
        nowMoney=nowMoney+deawingmoney;

        System.out.println(account.name+"余额为:"+account.money);

        System.out.println(this.getName()+"手里的钱:"+nowMoney);
    }
}