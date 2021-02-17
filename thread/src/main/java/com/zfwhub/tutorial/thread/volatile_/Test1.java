package com.zfwhub.tutorial.thread.volatile_;

public class Test1 {
    
    public static void main(String[] args) {
        Aborting a = new Aborting();
        a.start();
        for (; ; ) {
            synchronized (a) {
                if (a.isFlag()) {
                    System.out.println("有点东西");
                }
            }
        }
    }

}
