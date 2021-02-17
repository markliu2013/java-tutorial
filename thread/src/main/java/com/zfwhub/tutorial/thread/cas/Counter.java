package com.zfwhub.tutorial.thread.cas;

public class Counter {
    
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void add(){
        count += 1;
    }

    public synchronized void dec(){
        count -= 1;
    }

}
