package com.example.learnofmybatis.base.Thread;


import java.util.Objects;

public class ACcount {
     private int balance;

     void transfer(ACcount target,int amt) {
         synchronized (this) {
             synchronized (target) {
                 if(this.balance > amt) {
                     this.balance-=amt;
                     target.balance+=amt;
                 }
             }
         }
     }
 }
