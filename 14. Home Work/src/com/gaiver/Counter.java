package com.gaiver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {
    private int defaultCounter = 0;
    private volatile int volatileCounter = 0;
    private AtomicInteger atomicCounter = new AtomicInteger(0);
    private CountDownLatch gate = new CountDownLatch(1);
    public static CountDownLatch taskAwait = new CountDownLatch(2000);


    public void incrementDefaultCounter(){
        defaultCounter++;
//        System.out.println("D" + defaultCounter);
    }

    public void incrementVolatileCounter(){
        volatileCounter++;
//        System.out.println("V " + volatileCounter);
    }

    public void incrementAtomicCounter(){
        atomicCounter.addAndGet(1);
        System.out.println("A " + atomicCounter);
    }

    public int getDefaultCounter(){
        return defaultCounter;
    }

    public int getVolatileCounter() {
        return volatileCounter;
    }

    public AtomicInteger getAtomicCounter() {
        return atomicCounter;
    }

    public void startTasks(){
        gate.countDown();
    }

    @Override
    public void run() {
        try {
            gate.await();
            incrementDefaultCounter();
            incrementVolatileCounter();
            incrementAtomicCounter();
            taskAwait.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
