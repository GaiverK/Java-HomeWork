package com.company;

import java.io.*;

public class FileWriterReader {

    public void create1GBFile(String fileName){
        int fileSize = 1073741824;
        File watchFor = new File(fileName);
        if( watchFor.exists() && watchFor.length() >= fileSize ){
            System.out.println("Файл уже существует");
        }else {
            // Create file 1 GB
            try (OutputStream outStream = new FileOutputStream(fileName)) {
                int arraySize = 4096 * 2;
                byte[] bytesArray = new byte[arraySize];
                int starter = 0;
                while (bytesArray.length < arraySize) bytesArray[starter++] = 1;
                while (watchFor.length() < fileSize) {
                    outStream.write(bytesArray);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Создание файла завершено");
            }
        }
    }


    public void create1MBFile(String fileName){
        int fileSize = 1048576;
        File watchFor = new File(fileName);
        if( watchFor.exists() && watchFor.length() >= fileSize ){
            System.out.println("File already exists");
        }else {
            try (OutputStream outStream = new FileOutputStream(fileName)) {
                System.out.println(watchFor.length());
                int arraySize = 4096;
                byte[] bytesArray = new byte[arraySize];
                int starter = 0;
                while (bytesArray.length < arraySize) bytesArray[starter++] = 1;
                while (watchFor.length() < fileSize) {
                    outStream.write(bytesArray);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFileByOneByte(String fileName, String newFileName){
        try( InputStream inStream = new FileInputStream(fileName); OutputStream outStream = new FileOutputStream(newFileName) ){
            byte[] chunk = new byte[1];
            int ch;
            while((ch = inStream.read()) != -1){
                outStream.write(chunk, 0, ch);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void copyFileByLocalBuffer(String fileName, String newFileName){

        try( InputStream inStream = new FileInputStream(fileName); OutputStream outStream = new FileOutputStream(newFileName) ){
            byte[] bytes = new byte[4096];
            int ch;
            while((ch = inStream.read()) != -1){
                outStream.write(bytes, 0, ch);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void copyFileByBufferedOneByte(String fileName, String newFileName){
        int bufsize = 1;
        try( InputStream inStream = new BufferedInputStream(new FileInputStream(fileName), bufsize); OutputStream outStream = new BufferedOutputStream(new FileOutputStream(newFileName), bufsize) ){
            byte[] chunk = new byte[1];
            int ch;
            while((ch = inStream.read()) != -1){
                outStream.write(chunk, 0, ch);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void copyFileByBufferedBuffer(String fileName, String newFileName){
        int bufsize = 8192 * 2; // default * 2
        try( BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(fileName), bufsize); BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(newFileName), bufsize) ){
            byte[] bytes = new byte[4096];
            int readCount;
            while ((readCount = inStream.read(bytes)) > 0){
                outStream.write(bytes, 0, readCount);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
