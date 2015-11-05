package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.UserRole;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "user_seq")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
