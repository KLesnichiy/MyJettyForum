package ru.myforum.dao;

<<<<<<< HEAD

=======
import java.io.Serializable;
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import ru.myforum.model.*;

=======
import ru.myforum.model.Categories;
import ru.myforum.model.User;
import ru.myforum.model.UserRole;
import ru.myforum.model.Posts;
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
/**
 * Created by Шмель on 14.12.2017.
 */
@Repository
public class DataDaoImpl implements DataDao {

    @Autowired
    SessionFactory sessionFactory;



    @Transactional
    public void insertRow(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        session.close();
    }

<<<<<<< HEAD

    public void insertPost(Posts post) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Date now = new Date();
        post.setCreated(now);
=======
    @Transactional
    public void insertPost(Posts post) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
        session.saveOrUpdate(post);
        tx.commit();
        session.close();
    }

    @Transactional
    public void insertRole(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        UserRole role = new UserRole(user,"ROLE_USER");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        session.saveOrUpdate(role);
        tx.commit();
        session.close();
    }


    public List<User> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }

    public List<Categories> listCategories( ){
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Categories> categories = session.createQuery("from Categories").list();
        session.close();
        return categories;
    }

<<<<<<< HEAD
=======
    public Categories getCategories(int id ){
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Categories> categor = session.createQuery("from Categories where idcategories=?").setParameter(0, id)
                .list();
        session.close();
        if (categor.size() > 0) {
            return categor.get(0);
        } else {
            return null;
        }
    }
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0


    @SuppressWarnings("unchecked")
    public Posts getPost(int id) {
        Session session = sessionFactory.openSession();
        List<Posts> posts = new ArrayList<Posts>();
<<<<<<< HEAD
        posts = session.createQuery("from Posts where post_id=?").setParameter(0, id)
=======
        posts = session.createQuery("from Posts where id=?").setParameter(0, id)
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
                .list();
        session.close();
        if (posts.size() > 0) {
            return posts.get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Posts> getPostbyCategoria(int id) {
        Session session = sessionFactory.openSession();
        List<Posts> posts = new ArrayList<Posts>();
        posts = session.createQuery("from Posts where categories_id=?").setParameter(0, id)
                .list();
        session.close();
        if (posts.size() > 0) {
            return posts;
        } else {
            return null;
        }
    }

<<<<<<< HEAD

    @SuppressWarnings("unchecked")
    public List<Coments> getComentsFromPost(int id) {
        Session session = sessionFactory.openSession();
        List<Coments> coments = new ArrayList<Coments>();
        coments = session.createQuery("from Coments where post_id=?").setParameter(0, id)
                .list();
        session.close();
        if (coments.size() > 0) {
            return coments;
        } else {
            return null;
        }
    }

    public void insertComent(Coments coment) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Date now = new Date();
        coment.setCreated(now);
        session.saveOrUpdate(coment);
        tx.commit();
        session.close();
    }

=======
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
    @Transactional
    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }





}
