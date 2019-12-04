package com.gaiver.observer;

public class stopWatchPrintObserver implements Observer{
    @Override
    public void update(Long data, String state) {
       if("In process".equals(state)){
           System.out.println("Current second - " + data);
       }
    }
}
