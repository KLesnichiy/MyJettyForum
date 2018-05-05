package ru.myforum.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "posts", catalog = "springhibernate_db")
public class Posts {
    private int id;
    private String title;
    private String text;
    private int created;
    private Categories categories;

    public Posts() {
    }

    public Posts(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Posts(String title, String text, int created) {
        this.title = title;
        this.text = text;
        this.created= created;
    }

    public Posts(String title, String text, Categories categories) {
        this.title = title;
        this.text = text;
        this.categories = categories;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
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
    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
