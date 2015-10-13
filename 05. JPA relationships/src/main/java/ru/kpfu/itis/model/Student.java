package ru.kpfu.itis.model;

import javax.persistence.Entity;

@Entity
public class Student {

    private String name;

    private String surname;

    private String middlename;

    public Student() {
    }
}
