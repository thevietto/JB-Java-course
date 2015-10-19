package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
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
