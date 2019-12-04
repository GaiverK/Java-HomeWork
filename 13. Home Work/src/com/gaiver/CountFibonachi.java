package com.gaiver;
import java.math.BigInteger;
import java.util.concurrent.Callable;

public class CountFibonachi implements Callable<BigInteger> {
    private State state;
    private BigInteger first;
    private BigInteger second;
    private String result;
    public CountFibonachi(State st){
        state = st;
        first = state.first_num;
        second = state.second_num;
        System.out.println("Fibo starts with " + first + ", " + second);
    }

    public State getState(){
        return state;
    }
    @Override
    public BigInteger call() {
        System.out.println("Fibo counter started");
        int fibostep = 0;
        while(!Thread.currentThread().isInterrupted() && (state.maxSteps-- > 0)){
            BigInteger sec = second;
            second = second.add(first);
            first = sec;
            result = first + "," + second;
            state.first_num = first;
            state.second_num = second;
            System.out.println("Fibo step " + ++fibostep);
        }
        return second;
    }
}
