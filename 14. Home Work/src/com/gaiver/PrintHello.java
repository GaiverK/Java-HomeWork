package com.gaiver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrintHello {

    static CountDownLatch start = new CountDownLatch(1);
    static int counter = 0;

    public static void main(String[] args) {

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(()->{
            try {
                start.await();
                printHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tasks.add(()->{
            try {
                start.await();
                printWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);

        exec.scheduleWithFixedDelay(tasks.get(0), 0, 10, TimeUnit.SECONDS);
        exec.scheduleWithFixedDelay(tasks.get(1), 0, 10, TimeUnit.SECONDS);

        // start tasks together
        start.countDown();

        exec.schedule(()->{
            exec.shutdown();
        }, 60, TimeUnit.SECONDS);

    }

    static void printHello(){
        System.out.print("Hello ");
        counter++;
        printLn();
    }

    static void printWorld(){
        System.out.print("World ");
        counter++;
        printLn();
    }

    static void printLn(){
        if(counter == 2){
            System.out.println();
            counter = 0;
        }
    }

}
