
package ru.myforum.model;

        import javax.persistence.*;
        import java.util.HashSet;
        import java.util.Set;

<<<<<<< HEAD

=======
        import static javax.persistence.GenerationType.IDENTITY;
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0

@Entity
@Table(name = "categories", catalog = "springhibernate_db")
public class Categories {

    private int id;
    private String title;
    private String description;
    private Set<Posts> categ = new HashSet<Posts>(0);

    public Categories() {
    }


    @Id
<<<<<<< HEAD
    @Column(name = "categories_id", unique = true, nullable = false)
=======
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idcategories", unique = true, nullable = false)
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    public Set<Posts> getCateg() {
        return categ;
    }
    public void setCateg(Set<Posts> categ) {
        this.categ = categ;
    }
}
