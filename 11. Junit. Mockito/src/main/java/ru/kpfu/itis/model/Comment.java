package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by Maxim Ignatiev on 07.11.15.
 */
@Entity
@SequenceGenerator(sequenceName = "comment_seq", name = "comment_gen")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_gen")
    private long id;


    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tweet tweet;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
