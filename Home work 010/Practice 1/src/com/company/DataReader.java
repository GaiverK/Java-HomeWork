package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DataReader {

    public static void main(String[] args) {
        try {
            DataReader.readHundredIntegersAverage("./files/integers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            DataReader.readContacts("./files/contacts.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readContacts(String filename) throws FileNotFoundException {

        List<Contact> contacts = new ArrayList<>();
        // Read all contacts from file
        try(Scanner scanner = new Scanner(
                new FileInputStream(filename),
                StandardCharsets.UTF_8.name()
        )){
            while( scanner.hasNextLine() ){
                String singleLine = scanner.nextLine();
                String[] res = singleLine.split(" / ", 4);
                contacts.add(new Contact(res[0], res[1], res[2], res[3]));
            }
        }

        Contact[] conts = contacts.toArray(new Contact[0]);

        DataReader.printTitle();

        // Sort and print contacts by birthday
        Arrays
                .stream(conts, 0, 5)
                .sorted(Comparator.comparingInt(contact -> Integer.parseInt(contact.birthdate)))
                .forEach(item -> DataReader.printData(item));

    }

    public static void readHundredIntegersAverage(String filename) throws FileNotFoundException {
        List<Integer> positiveIntegers = new ArrayList<>();
        try(Scanner scanner = new Scanner(
                new FileInputStream(filename), StandardCharsets.UTF_8.name())){
                    scanner.useDelimiter(", ");
                    int max = 100;
                    int starter = 0;
                    while (scanner.hasNextInt()){
                        if( starter++ == max ) break;
                        positiveIntegers.add(scanner.nextInt());
                    }
                }

        System.out.println("Среднее значение положительных чисел: " + positiveAverage(positiveIntegers));

    }

    static void printData(Contact contact){
        System.out.printf("Имя: %s / Фамилия: %s / Телефон: %s / Дата Рождения: %s\n",
                contact.getName(),
                contact.getSurname(),
                contact.getPhone(),
                contact.getBirthdate()
        );
    }

    static void printTitle(){
        System.out.println("==============================Первые 5 контактов===============================");
    }

    private static double positiveAverage(List<Integer> integers){
        int how_many = 0;
        int summa = 0;
        for (Integer num: integers) {
            if( num >= 0 ){
                summa += num;
                how_many++;
            }
        }
        return summa / how_many;
    }
}
