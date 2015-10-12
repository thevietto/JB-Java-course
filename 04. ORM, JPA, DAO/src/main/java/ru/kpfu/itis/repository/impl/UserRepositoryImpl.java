package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createNativeQuery("SELECT * FROM users", User.class).getResultList();
    }

    @Override
    public User findUserByLogin(String login) {
        Query query = em.createNativeQuery("SELECT * FROM users WHERE login = ?");
        query.setParameter(1, login);
        return (User) query.getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }
}
