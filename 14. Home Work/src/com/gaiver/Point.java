package com.gaiver;

import java.util.concurrent.CountDownLatch;

public class Point implements Runnable {
    private int x = 0;
    private int y = 0;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private final Object lock = new Object();
    private CountDownLatch gate = new CountDownLatch(1);
    static CountDownLatch stopGate = new CountDownLatch(2000);

    // Self class monitor
    private synchronized void movePoint(){
        x++;
        y++;
    }

    // Without synchronize
    private void movePointDefault(){
        c++;
        d++;
    }

    // Object monitor
    private void movePointLock(){
        synchronized (lock){
            a++;
            b++;
        }
    }

    public String getCoords(){
        return "X:"+x+" Y:"+y;
    }

    public String getCoordsLock(){
        return "A:"+a+" B:"+b;
    }

    public String getCoordsDefault(){
        return "C:"+c+" D:"+d;
    }

    public void startTasks(){
        gate.countDown();
    }

    @Override
    public void run() {
        try {
            gate.await();
            movePointDefault();
            movePoint();
            movePointLock();
            stopGate.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
