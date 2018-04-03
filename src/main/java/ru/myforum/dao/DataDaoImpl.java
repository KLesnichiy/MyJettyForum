package ru.myforum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import ru.myforum.model.User;

/**
 * Created by Шмель on 14.12.2017.
 */
public class DataDaoImpl implements DataDao {

    @Autowired
    SessionFactory sessionFactory;



    @Transactional
    public void insertRow(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
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
