package ru.kpfu.itis.repository;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Student;

@Repository
public interface StudentRepository {

    Student find(Long id);

    void save(Student student);

}
