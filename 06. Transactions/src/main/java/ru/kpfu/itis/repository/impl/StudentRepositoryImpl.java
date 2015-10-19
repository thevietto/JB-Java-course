package ru.kpfu.itis.repository.impl;

import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Student find(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        em.persist(student);
    }
}
