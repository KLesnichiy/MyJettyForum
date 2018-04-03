package ru.myforum.model;

import javax.persistence.*;

@Entity
@Table(name = "posts", catalog = "springhibernate_db")

public class Posts {

    private int id;
    private String title;
    private String text;
    private int date;
    private User user;

    public Posts() {
    }

    public Posts(int id, String title, String text, int date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false, length = 70)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "text", nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Column(name = "date", nullable = false)

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
