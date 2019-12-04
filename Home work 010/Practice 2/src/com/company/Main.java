package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Path filePath = null;

        try {
            filePath = Paths.get(args[0]); // Path from argument
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        String absPath = filePath.toAbsolutePath().toString();

        // Create dirs for files
        new File(absPath).mkdirs();

        // Names of files with path from argument
        String fileNameGB = Paths.get(absPath, "1GBtest.txt").toString();
        String copyFileNameGB = Paths.get(absPath, "1GBtestCopy.txt").toString();
        String fileNameMB = Paths.get(absPath, "1MBtest.txt").toString();
        String copyFileNameMB = Paths.get(absPath, "1MBtestCopy.txt").toString();

        List<Consumer<FileWriterReader>> consumers = new ArrayList<>();
        consumers.add(fwr -> {fwr.create1GBFile(fileNameGB);
            System.out.print("Process - create1GBFile");});

        consumers.add(fwr -> {fwr.create1MBFile(fileNameMB);
            System.out.print("Process - create2MBFile");});

        consumers.add(fwr -> {fwr.copyFileByOneByte(fileNameMB, copyFileNameMB);
            System.out.print("Process - copyFileByOneByte");});

        consumers.add(fwr -> {fwr.copyFileByLocalBuffer(fileNameGB, copyFileNameGB);
            System.out.print("Process - copyFileByLocalBuffer");});

        consumers.add(fwr -> {fwr.copyFileByBufferedOneByte(fileNameMB, copyFileNameMB);
            System.out.print("Process - copyFileByBufferedOneByte");});

        consumers.add(fwr -> {fwr.copyFileByBufferedBuffer(fileNameGB, copyFileNameGB);
            System.out.print("Process - copyFileByBufferedBuffer");});

        measureTime(consumers);
    }

    private static void measureTime(List<Consumer<FileWriterReader>> consumers) { // Measure with List<Consumer>
        FileWriterReader fwr = new FileWriterReader();
        NumberFormat formatter = new DecimalFormat("#0.00");
        for (Consumer consumer : consumers) {
            long start = System.nanoTime();
            consumer.accept(fwr);
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            System.out.println(" - Finished in " + timeElapsed + " ns");
        }
    }
}
