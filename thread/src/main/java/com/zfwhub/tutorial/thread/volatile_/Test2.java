package com.zfwhub.tutorial.thread.volatile_;

public class Test2 {
    
    public static void main(String[] args) {
        Aborting a = new Aborting();
        a.start();
        for (; ; ) {
            if (a.isFlag()) {
                System.out.println("有点东西");
            }
        }
    }

}
