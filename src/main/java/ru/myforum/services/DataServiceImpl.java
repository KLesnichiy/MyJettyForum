package ru.myforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.myforum.dao.DataDao;
import ru.myforum.model.Categories;
<<<<<<< HEAD
import ru.myforum.model.Coments;
=======
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
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

<<<<<<< HEAD
    public List<Coments> getComentsFromPost(int id){return dataDao.getComentsFromPost(id);}

    public void insertComent(Coments coment){dataDao.insertComent(coment);}




=======
    public Categories getCategories(int id ){return dataDao.getCategories(id);};
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0
}
