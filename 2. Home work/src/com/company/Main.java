package com.company;

public class Main {


    public static void main(String[] args) {


        // Task 1,2 - Fill array with some students

        // StudentFactory
        StudentFactory sfact = new StudentFactory();

        Student[] students = new Student[10];

        for(int i = 0; i < students.length; i++){
            Student nst = sfact.getNewStudent();
            students[i] = nst;
        }
        // end of task 1,2

        // Task 3 - Sort students by name
        ArrayBubble array = new ArrayBubble(students);

        array.bubbleSorter("byName");
        array.printer();// Print students array
        // end of task 3

        // Task 4 - Sort students by age
        array.bubbleSorter("byAge");
        array.printer();// Print students array
        // end of task 4

        // Task 5 - Find student by part of name and return object or null
        String searchText = "ant";
        Student s = sfact.searchStudentByPart(searchText, students);
        if( s != null ) System.out.println("Найден студент по запросу \""+ searchText +"\" - " + s.student_name + " " + s.student_age);
        else System.out.println("По запросу \""+ searchText +"\" " + " нет совпадений");
        // end of task 5


        // Task 6 - Find students by part of name and return array with students or empty array
        searchText = "yas";
        Student[] finded_results = sfact.searchStudentByPart(searchText, students, "return array");
        sfact.printArr(finded_results);
        // end of task 6







    }


}
