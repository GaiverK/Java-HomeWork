package com.company;

public class Student {
    String name;
    int age;
    String groupName;

    public Student(String name, int age, String groupName) {
        this.name = name;
        this.age = age;
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroupName() {
        return groupName;
    }
}
