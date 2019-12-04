package com.gaiver;
import java.math.BigInteger;
import java.util.concurrent.Callable;

public class CountFactorial implements Callable<BigInteger> {

    private BigInteger result;

    public CountFactorial(BigInteger num){
        result = num;
    }

    @Override
    public BigInteger call() throws Exception {
        System.out.println("Factorial started");
        int step = 0;
        BigInteger factorialRes = new BigInteger("1");
        while (result.intValue() > 1 && !Thread.currentThread().isInterrupted()){
            factorialRes = factorialRes.multiply(result);
            result = result.subtract(new BigInteger("1"));
            System.out.println("Factorial step " + ++step);
        }
        return factorialRes;
    }
}
