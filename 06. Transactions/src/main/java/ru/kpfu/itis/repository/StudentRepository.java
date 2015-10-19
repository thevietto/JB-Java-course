package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Student;


public interface StudentRepository {

    Student find(Long id);

    void save(Student student);

}
