package com.gaiver;
import java.io.*;
import java.util.concurrent.Callable;

public class FileWorker implements Callable<String> {
    private String filePath = "./files/siluet.jpg";
    private String copyTo = "./files/copy.jpg";
    private File nf;
    private File cf;
    private long sizeByte = 1048576 * 10;

    public FileWorker(){
        nf = new File(filePath);
        cf = new File(copyTo);
    }

    @Override
    public String call(){
        System.out.println("FileWorker - Copy started");
            try(FileInputStream fis = new FileInputStream(nf);FileOutputStream fos = new FileOutputStream(cf)) {
                System.out.println("FileWorker - files opened");
                byte[] buff = new byte[4096];
                System.out.println("FileWorker - buffer ready");
                int ch;
                while((ch = fis.read(buff)) != -1 && !Thread.currentThread().isInterrupted()){
                    fos.write(buff, 0, ch);
                    System.out.println("FileWorker - write buffer to file");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "Copy finished to file " + cf.getAbsolutePath();
    }
}
