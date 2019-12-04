package com.gaiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Task 3 in file PrintHello
        // Task 1 - increment counter
        Counter counter = new Counter();

        ExecutorService executorService = Executors.newFixedThreadPool(50);
	    int tasksCounter = 0;
	    while(tasksCounter++ < 2000){
	        executorService.execute(counter);
        }

	    // Start all
        counter.startTasks();

	    // Show result
        try {
            // Wait for result
            Counter.taskAwait.await();
            System.out.println("Default result " + counter.getDefaultCounter()); // Sometimes failed
            System.out.println("Volatile result " + counter.getVolatileCounter()); // Sometimes failed
            System.out.println("Atomic result " + counter.getAtomicCounter()); // Always 2000 - good solution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Shutdown executor
        executorService.shutdown();

        // Task 2 - move point

        Point point = new Point();

        executorService = Executors.newFixedThreadPool(50);
        tasksCounter = 0;
        while (tasksCounter++ < 2000){
            executorService.execute(point);
        }

        point.startTasks();

        try {
            // Wait for result
            Point.stopGate.await();

            // Print result
            System.out.println(point.getCoordsDefault()); // Bad solution
            System.out.println(point.getCoords()); // Good solution
            System.out.println(point.getCoordsLock()); // Good solution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executorService.shutdown();
    }
}
