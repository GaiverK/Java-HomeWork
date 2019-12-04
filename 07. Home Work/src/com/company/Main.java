package com.company;

import MyOptional.MyOptional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws Exception {
        String spliter = "-----------------------------------------------";

        // Initialize MyOptional instance by ofNullable() and of(), and test equals
        MyOptional<Integer> intOpt = MyOptional.ofNullable(null);
        MyOptional<String> intOpt2 = MyOptional.ofNullable(null);
        MyOptional<String> intOpt3 = MyOptional.of("Test String"); // Test method MyOptional.of()

        System.out.println(intOpt.equals(intOpt2)); // true

        intOpt = MyOptional.ofNullable(333);
        intOpt2 = MyOptional.ofNullable("Hello");

        System.out.println(intOpt.equals(intOpt2)); // false

        intOpt2 = MyOptional.ofNullable("Test String");

        System.out.println(intOpt3.equals(intOpt2)); // true
        // End of equals test

        System.out.println(spliter);

        // Test hashcode
        intOpt = MyOptional.ofNullable(null);

        System.out.println(intOpt.hashCode()); // Waiting for zero

        intOpt = MyOptional.ofNullable(12); // Change for non zero

        System.out.println(intOpt.hashCode());

        System.out.println(intOpt3.hashCode()); // String hashcode
        // End of hashcode test

        System.out.println(spliter);

        // orElse test
        intOpt3 = MyOptional.empty();

        System.out.println(intOpt3.orElse("Other String")); // Other because intOpt3 value is null

        intOpt3 = MyOptional.ofNullable("Real String");

        System.out.println(intOpt3.orElse("Other String")); // Real because intOpt3 value not null
        // End of orElse test


        System.out.println("----------------------if present test----------------------------");
        intOpt3 = MyOptional.ofNullable("Consumer write me");
        Consumer<String> consumer = (v) -> System.out.println(v);
        intOpt3.ifPresent(consumer);
        intOpt3 = MyOptional.ofNullable(null);
        intOpt3.ifPresent(consumer);// Do nothing, value is null
        intOpt3 = MyOptional.ofNullable("Consumer write me");
//        intOpt3.ifPresent(null); // Exception Consumer is null

        System.out.println("----------------------orElseGet test----------------------------");
        intOpt3 = MyOptional.ofNullable("Print me");
        System.out.println(intOpt3.orElseGet(null)); // Print value

        intOpt3 = MyOptional.ofNullable(null);
//        System.out.println(intOpt3.orElseGet(null)); // Exception Supplier is null

        Supplier<String> suppInt = () -> "NEW STRING";
        System.out.println(intOpt3.orElseGet(suppInt)); // Print other value from Supplier

        System.out.println("----------------------orElseThrow test----------------------------");

        intOpt3 = MyOptional.ofNullable("TEST"); // return value
//        intOpt3 = MyOptional.ofNullable(null); // throw Exception
        Supplier<Exception> exceptionSupplier = NullPointerException::new;
        intOpt3.orElseThrow(exceptionSupplier);
        System.out.println(intOpt3.get());

        System.out.println("----------------------filter test----------------------------");

        intOpt3 = MyOptional.ofNullable("Test");
        Predicate<String> predicate = value -> value.equals("Test");
        MyOptional result = intOpt3.filter(predicate);
        System.out.println(result.isPresent()); // return True

        intOpt3 = MyOptional.ofNullable("Test2"); // Change value
        result = intOpt3.filter(predicate);
        System.out.println(result.isPresent()); // return False

//        result = intOpt3.filter(null);  // Predicate exception

        System.out.println("----------------------map test----------------------------");

        intOpt3 = MyOptional.of("Length");
        Function<String, Integer> testFunc = String::length; // What is the string "length" length?
        MyOptional res = intOpt3.map(testFunc);
        System.out.println(res.get()); // Right answer is 6

        System.out.println("----------------------Flatmap test----------------------------");

        intOpt3 = MyOptional.of("Length");
        Function<String, MyOptional<String>> upperFunc = item -> {
            return MyOptional.ofNullable(item.toUpperCase());
        };
        res = intOpt3.flatMap(upperFunc);
        System.out.println(res.get()); // Must be LENGTH
    }
}
