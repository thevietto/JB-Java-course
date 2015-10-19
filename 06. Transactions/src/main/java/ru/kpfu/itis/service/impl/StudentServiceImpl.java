package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.repository.StudentRepository;
import ru.kpfu.itis.service.StudentService;

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
