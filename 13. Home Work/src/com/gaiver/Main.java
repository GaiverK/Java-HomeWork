package com.gaiver;
import com.gaiver.observer.stopWatchPrintObserver;
import com.gaiver.observer.stopWatchMeasureObserver;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Main {
    static Future<Long> stopW = null;
    public static void main(String[] args) {

        // Error descriptions
        Map<String, String> errorsDescription = new HashMap<>();
        errorsDescription.put("InterruptedException", "process was interupted");
        errorsDescription.put("ExecutionException", "process execution excepted");
        errorsDescription.put("TimeoutException", "process timeout");

        // Task 1 - Factorial
        Callable<BigInteger> factorialTask = new CountFactorial(new BigInteger("1000"));
        ExecutorService execFact = Executors.newSingleThreadExecutor();
        Future<BigInteger> resultFact = execFact.submit(factorialTask);

        doResult(resultFact, execFact, "Factorial", errorsDescription, null);


        // Task 2 - Fibonacci - with State pattern
        State st = new State();
        CountFibonachi fibo = new CountFibonachi(st);
        ExecutorService execFibo = Executors.newSingleThreadExecutor();
        Future<BigInteger> resultFibo = execFibo.submit(fibo);
        State lastState;
        // Save last State
        lastState = countFibo(resultFibo, execFibo, fibo);

        // Continue count Fibonacci
        fibo = new CountFibonachi(lastState);
        ExecutorService execFiboContinue = Executors.newSingleThreadExecutor();
        resultFibo = execFiboContinue.submit(fibo);
        fibo.getState().maxSteps = 5;
        // Do not save last State
        countFibo(resultFibo, execFiboContinue, fibo);



        // Task 3 - StopWatch with Observer pattern
        StopWatch stopWatch = new StopWatch();

        // Initialize observers
        stopWatchPrintObserver swpo = new stopWatchPrintObserver();
        stopWatchPrintObserver swpo2 = new stopWatchPrintObserver();
        stopWatchMeasureObserver swMeasure = new stopWatchMeasureObserver();

        // Add observers to list
        stopWatch.addObserver(swpo);
        stopWatch.addObserver(swpo2);
        stopWatch.addObserver(swMeasure);

        // Remove redundant observer
        stopWatch.removeObserver(swpo2); // One instance enough, unsubscribe

        ExecutorService execstopWatch = Executors.newSingleThreadExecutor();
        stopW = execstopWatch.submit(stopWatch);

        doResult(stopW, execstopWatch, "StopWatch", errorsDescription, swMeasure);


        // Task 4 - Streams
//      // For testing put some picture in root/files/siluet.jpg
//        Callable<String> FileWorker = new FileWorker();
//        ExecutorService execFileWorker = Executors.newFixedThreadPool(10);
//        Future<String> fwRes = execFileWorker.submit(FileWorker);
//
//        doResult(fwRes, execFileWorker, "FileWorker", errorsDescription);
    }

    static void doResult(Future<?> future, ExecutorService executor, String workerName, Map<String, String> errorsDescription, stopWatchMeasureObserver swMeasure ){
        try{
            System.out.printf("==================================================================\n"+
                    "Result: \n%s" +
                    "\n==================================================================\n",
                    future.get(20, TimeUnit.SECONDS)
                    );
        } catch (InterruptedException e) {
            System.out.printf("%s - %s\n",
                    workerName,
                    errorsDescription.get("InterruptedException")
            );
            future.cancel(true);
        } catch (ExecutionException e) {
            System.out.printf("%s - %s\n",
                    workerName,
                    errorsDescription.get("ExecutionException")
            );
        } catch (TimeoutException e) {
            System.out.printf("%s - %s\n",
                    workerName,
                    errorsDescription.get("TimeoutException")
            );

            future.cancel(true);
            System.out.println("Future canceled");
        } finally {
            System.out.println("ShutDown started");
            executor.shutdown();
            if( swMeasure != null){
                System.out.println("Time spent " + swMeasure.getTimeSpent() + " ns");
            }
        }
    }

    static State countFibo(Future<BigInteger> resultFibo, ExecutorService execFibo, CountFibonachi fibo){
        State lastState;
        try{
            BigInteger res = resultFibo.get(1, TimeUnit.MILLISECONDS);
            System.out.println("Fibo counted normal");
            System.out.println(res);
        } catch (InterruptedException e) {
            System.out.println("Fibo process was interupted");
            resultFibo.cancel(true);
        } catch (ExecutionException e) {
            System.out.println("Fibo process execution excepted");
        } catch (TimeoutException e) {
            System.out.println("Fibo process timeout");
            resultFibo.cancel(true);
        }finally {
            execFibo.shutdown();
            lastState = fibo.getState();
            System.out.println("Last state = " + lastState.first_num + ", " + lastState.second_num);
        }
        return lastState;
    }
}
