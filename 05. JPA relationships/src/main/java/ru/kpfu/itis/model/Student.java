package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.GenderType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    private long id;

    private String name;

    private String surname;

    private String middlename;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Document> documents;

    @ManyToMany
    @JoinTable(name = "student_elective",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "elective_id")})
    private List<Elective> electives;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Elective> getElectives() {
        return electives;
    }

    public void setElectives(List<Elective> electives) {
        this.electives = electives;
    }
}
