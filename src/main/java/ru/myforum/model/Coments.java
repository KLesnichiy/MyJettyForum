package ru.myforum.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coments", catalog = "springhibernate_db")
public class Coments {


    private int id;
    private String text;
    private Date created;
    private Posts posts;
    private User user;


    public Coments() {
    }

    public Coments(String text, Posts post) {
        this.text = text;
        this.posts = post;
    }

    @Id
    @GeneratedValue
    @Column(name = "coment_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "text" , length = 65535)
    @Type(type="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
