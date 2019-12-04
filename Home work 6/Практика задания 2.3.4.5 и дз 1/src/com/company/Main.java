package com.company;

import com.company.printer.Printer;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        StudentComparator studentComparator = new StudentComparator();
        Printer printer = new Printer();


        Student st1 = new Student("Kolya", 28);
        Student st2 = new Student("Kolya", 27);
        Student st3 = new Student("Katya", 56);
        Student st4 = new Student("Anatoly", 45);

        // Array of students
        Student[] students = new Student[4];
        students[0] = st1;
        students[1] = st2;
        students[2] = st3;
        students[3] = st4;

        // Static inner classes of comparator
        Arrays.sort(students, Student.studentCompararatorByAge());
        printer.consolePrint(students, "I Compare by age");
        Arrays.sort(students, Student.studentCompararatorByName());
        printer.consolePrint(students, "I Compare by name");
        Arrays.sort(students, Student.studentCompararatorByAgeName());
        printer.consolePrint(students, "I Compare by name or age");


        // Anonim classes of comparator
        Arrays.sort(students, studentComparator.getAnonimComparatorByAge());
        printer.consolePrint(students, "A Compare by age");
        Arrays.sort(students, studentComparator.getAnonimComparatorByName());
        printer.consolePrint(students, "A Compare by name");
        Arrays.sort(students, studentComparator.getAnonimComparatorByNameOrAge());
        printer.consolePrint(students, "A Compare by name or age");



        // Compare by age with lambda
        Arrays.sort(students, (s1, s2)->{
            return Integer.compare(s1.getAge(), s2.getAge());
        });

        printer.consolePrint(students, "L Compare by age");

        // Compare by name with lambda
        Arrays.sort(students, (s1, s2)->{
            return s1.getName().compareTo(s2.getName());
        });

        printer.consolePrint(students, "L Compare by name");

        // Compare by name, if the same name then compare by age with lambda
        Arrays.sort(students, (s1, s2)->{
            if( !s1.getName().equals(s2.getName()) ) return s1.getName().compareTo(s2.getName());
            else return Integer.compare(s1.getAge(), s2.getAge());
        });

        printer.consolePrint(students, "L Compare by name or age");

    }
}
