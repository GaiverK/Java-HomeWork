package com.company;

public class Student {
    String name;
    int age;

    public void setName(String name) {
        if(name == null) throw new NullPointerException("Передан null в качестве аргумента");
        if( name.isEmpty() ) throw new IllegalArgumentException("Передано неккоректное имя");
        this.name = name;
    }

    public void setAge(int age) {
        if( age <= 0 ) throw new IllegalArgumentException("Передан неккоректный возраст");
        this.age = age;
    }

    public static Student deserialize(String studentName) throws MyDomainExcception {
        if( studentName == null ){
            throw new MyDomainExcception("Передан неверный аргумент");
        }
        Student nst = new Student();
        nst.setName(studentName);
        return nst;
    }
}
