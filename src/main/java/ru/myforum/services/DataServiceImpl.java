package ru.myforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.myforum.dao.DataDao;
import ru.myforum.model.Categories;
import ru.myforum.model.Posts;
import ru.myforum.model.User;

import java.util.List;

/**
 * Created by Шмель on 14.12.2017.
 */
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;


    public void insertRow(User user) {
        dataDao.insertRow(user);
    }


    public List<User> getList() {
        return dataDao.getList();
    }


    public User findByUserName(String username) {
        return dataDao.findByUserName(username);
    }


    public void insertRole(User user) { dataDao.insertRole(user); }

    public Posts getPost(int id) {return dataDao.getPost(id);}

    public List<Categories> listCategories(){return dataDao.listCategories(); }

    public List<Posts> getPostbyCategoria(int id){return dataDao.getPostbyCategoria(id);}

    public void insertPost(Posts post){dataDao.insertPost(post);}

    public Categories getCategories(int id ){return dataDao.getCategories(id);};
}
