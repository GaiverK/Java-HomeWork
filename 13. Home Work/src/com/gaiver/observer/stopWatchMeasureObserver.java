package com.gaiver.observer;

public class stopWatchMeasureObserver implements Observer{
    private long processStarted;
    private long processStopped = -1;

    public long getTimeSpent() {
        while (processStopped == -1){
            // wait for finish, if stopWatch interrupted without while, processStopped = 0
        }
        return processStopped - processStarted;
    }

    @Override
    public void update(Long data, String state) {
        // Do nothing
        if( "Started".equals(state) ){
            System.out.println("START CHECKED");
            processStarted = System.nanoTime();
        }else if( "Finished".equals(state) ){
            System.out.println("STOP CHECKED");
            processStopped = System.nanoTime();
        }
    }
}
