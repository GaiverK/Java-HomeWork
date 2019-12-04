package com.company.printer;

import com.company.Student;

public class Printer {

  public void consolePrint(Student[] students, String subject){
        System.out.println("================== "+subject+" =================");
        for( Student student : students ){
            System.out.printf("Имя студента: %-10s возраст: % 3d\n",
                    student.getName(),
                    student.getAge()
            );
        }
      System.out.println("=========================================================");
  }
}
