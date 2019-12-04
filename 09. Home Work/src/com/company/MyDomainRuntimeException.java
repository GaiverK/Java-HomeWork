package com.company;

public class MyDomainRuntimeException extends RuntimeException {
    public MyDomainRuntimeException(String errorDetails, Exception e){
        super(errorDetails, e);
    }
}
