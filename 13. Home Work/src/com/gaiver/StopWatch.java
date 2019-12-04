package com.gaiver;
import com.gaiver.observer.Observed;
import com.gaiver.observer.Observer;
import com.gaiver.observer.stopWatchPrintObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class StopWatch implements Callable<Long>, Observed {
    List<Observer> subscribers = new ArrayList<>();
    private String state = "Not initialized";
    private long currentSecond = 0;
    private int maxSeconds = 20;
    private boolean processStarted = false;
    private boolean processFinished = false;
    @Override
    public Long call(){
        if( !processStarted ){
            processStarted = true;
            state = "Started";
            notifyAllObs();
            state = "In process";
        }
        while (!Thread.currentThread().isInterrupted() && maxSeconds-- > 0){
            currentSecond++;
            notifyAllObs();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                if( !processFinished ){
                    processFinished = true;
                    state = "Finished";
                    notifyAllObs();
                    state = "Closed";
                }
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        if( !processFinished ){
            processFinished = true;
            state = "Finished";
            notifyAllObs();
            state = "Closed";
        }
        return currentSecond;
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyAllObs() {
        for (Observer subscriber :
                this.subscribers) {
            subscriber.update(currentSecond, state);
        }
    }


}
