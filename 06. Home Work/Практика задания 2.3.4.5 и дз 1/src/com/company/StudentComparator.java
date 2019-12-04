package com.company;

import java.util.Comparator;

public class StudentComparator {

    // Static classes of comparator
    static class CompareByName implements Comparator<Student>{
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getName().compareTo( student2.getName() );
        }
    }

    static class CompareByAge implements Comparator<Student>{
        @Override
        public int compare(Student student1, Student student2) {
            return Integer.compare(student1.getAge(), student2.getAge());
        }
    }

    static class CompareByNameOrAge implements Comparator<Student>{
        @Override
        public int compare(Student student1, Student student2) {
            if( !student1.getName().equals( student2.getName() ) ) return student1.getName().compareTo( student2.getName() );
            else return Integer.compare( student1.getAge(), student2.getAge() );
        }
    }

    // Anonim classes of comparator
    public Comparator getAnonimComparatorByAge(){

        return new Comparator<Student>(){
            @Override
            public int compare(Student student1, Student student2) {
                return Integer.compare(student1.getAge(), student2.getAge());
            }
        };

    }

    public Comparator getAnonimComparatorByName(){

        return new Comparator<Student>(){
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        };

    }

    public Comparator getAnonimComparatorByNameOrAge(){

        return new Comparator<Student>(){
            @Override
            public int compare(Student student1, Student student2) {
                if( !student1.getName().equals(student2.getName()) ) return student1.getName().compareTo(student2.getName());
                else return Integer.compare(student1.getAge(), student2.getAge());
            }
        };

    }

}
