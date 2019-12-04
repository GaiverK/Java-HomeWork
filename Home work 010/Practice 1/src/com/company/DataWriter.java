package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {

    public static void main(String[] args) {
        try {
            DataWriter.writeIntegers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DataWriter.writeHelloWorld();
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
            e.printStackTrace();
        }

        try {
            DataWriter.writeContacts("./files/contacts.txt", DataWriter.getContacts());
        }catch (IOException e){
            System.out.println("Возможно произошла ошибка файла");
            e.printStackTrace();
        }
    }

    public static void writeHelloWorld() throws FileNotFoundException {

        try(PrintWriter pw = new PrintWriter(
                new FileOutputStream("./files/task1.txt"))){
            pw.println("Hello, world!");
        }

    }

    public static void writeIntegers() throws FileNotFoundException {
            int start = 0;
            try(PrintWriter pw = new PrintWriter(
                    new FileOutputStream("./files/integers.txt"))){
                while( start++ < 1000 ){
                    int rand = (int)(Math.random()*1151 - 500);
                    pw.print(rand);
                    if( start < 1000 ) pw.print(", ");
                }
            }
    }

    public static void writeContacts(String filename, List<Contact> contacts) throws FileNotFoundException{

        try(PrintWriter pw = new PrintWriter(
                new FileOutputStream(filename))){
            contacts
                    .stream()
                    .forEach(contact -> pw.printf("%s / %s / %s / %s\n",
                            contact.getName(),
                            contact.getSurname(),
                            contact.getPhone(),
                            contact.getBirthdate()
                    ));
        }
    }

    private static List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Vasya", "Vasilyev", "+380507643523", "1984"));
        contacts.add(new Contact("Petya", "Petrov", "+380507643523", "1987"));
        contacts.add(new Contact("Egor", "Egorov", "+380507643523", "1983"));
        contacts.add(new Contact("Anton", "Nikulin", "+380507643523", "1971"));
        contacts.add(new Contact("Nikita", "Andreev", "+380507643523", "1964"));
        contacts.add(new Contact("Alex", "Alexov", "+380507643523", "1881"));
        contacts.add(new Contact("Fedya", "Fedotov", "+380507643523", "1989"));
        contacts.add(new Contact("Stas", "Mihaylov", "+380507643523", "1988"));
        contacts.add(new Contact("Andrey", "Tan", "+380507643523", "1987"));
        contacts.add(new Contact("Mark", "Cukerberg", "+380507643523", "1986"));
        contacts.add(new Contact("Ilon", "Mask", "+380507644523", "1977"));
        contacts.add(new Contact("Mustafa", "Sandal", "+380507643512", "1955"));
        return contacts;
    }
}


