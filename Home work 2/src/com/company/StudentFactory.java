package com.company;

import java.util.Random;

public class StudentFactory {

    public Student getNewStudent(){ // Create students
        Student nst = new Student();
        String[] names = new String[]{"Petya", "Vasya", "Kolya", "Anton", "Maria", "Katya", "Vera", "Ira", "Olya"};
        int[] ages = new int[]{34, 56, 22, 41, 37, 32, 56, 43, 45};
        int random_name = (int)(Math.random() * (names.length-1) + 1);
        int random_age = (int)(Math.random() * (ages.length - 1) + 1);
        nst.student_name = names[random_name];
        nst.student_age = ages[random_age];
        return nst;
    }

    public Student searchStudentByPart(String textPart, Student[] aStudents){ // Find single student by part of text and return object or null
        for(Student k : aStudents){
            if( k.student_name.toLowerCase().contains(textPart.toLowerCase()) ) return k;
        }

        return null;
    }

    public Student[] searchStudentByPart(String textPart, Student[] aStudents, String retType){ // Find students by text part and retun array
        int matches = 0;

        for(Student k : aStudents){// Find matches
            if( k.student_name.toLowerCase().contains(textPart.toLowerCase()) ){
                matches++;
            }
        }

        if( matches > 0 ){ // If matches greater then 0 create new array with matches length and fill it
            Student[] searcher = new Student[matches];
            int fillArr = 0;
            for(Student k : aStudents){
                if( k.student_name.toLowerCase().contains(textPart.toLowerCase()) ){
                    searcher[fillArr++] = k;
                }
            }
            return searcher;
        }
        return new Student[0];
    }

    public void printArr(Student[] aStudents){ // Print array
        System.out.println("-----------------Start---------------------");
        if( aStudents.length == 0 ){
            System.out.println("Пустой массив");
        }

        for(Student k : aStudents){
            System.out.println(k.student_name + " " + k.student_age);
        }
        System.out.println("-----------------End---------------------");
    }


}
