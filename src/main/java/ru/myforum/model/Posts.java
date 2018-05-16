package ru.myforum.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "posts", catalog = "springhibernate_db")
public class Posts {
    private int id;
    private String title;
    private String text;
    private Date created;
    private Categories categories;
    private User user;
    private Set<Coments> coments = new HashSet<Coments>(0);


    public Posts() {
    }

    public Posts(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Posts(String title, String text, Date created) {
        this.title = title;
        this.text = text;
        this.created= created;
    }

    public Posts(int id,String title, String text, Categories categories) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.categories = categories;
    }

    @Id
    @GeneratedValue
    @Column(name = "post_id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "text" , length = 65535)
    @Type(type="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", nullable = false)
    public Categories getCategories() {
        return categories;
    }


    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "posts")
    public Set<Coments> getComents() {
        return coments;
    }

    public void setComents(Set<Coments> coments) {
        this.coments = coments;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_name", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
