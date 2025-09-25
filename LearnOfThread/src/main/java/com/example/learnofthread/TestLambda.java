package com.example.learnofthread;


public class TestLambda {

    // 静态内部类
    static  class  Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("Like3");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();

        // 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("Like4");
            }
        };

        like.lambda();

        like =  ()->{
            System.out.println("Like5");
        };
        like.lambda();

        new Thread(()-> System.out.println("Hello")).start();
    }

}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("Like lambda");
    }
}
