package com.company;

public class Contact {
    String name;
    String surname;
    String phone;
    String birthdate;

    public Contact(String name, String surname, String phone, String birthdate) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
