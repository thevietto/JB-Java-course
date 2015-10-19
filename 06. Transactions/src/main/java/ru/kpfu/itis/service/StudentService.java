package ru.kpfu.itis.service;


import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Student;

@Service
public interface StudentService {

    void saveStudent(Student student);


    void debugThis();

}
