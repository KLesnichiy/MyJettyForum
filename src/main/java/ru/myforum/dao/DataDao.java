package ru.myforum.dao;

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
public interface DataDao {


    public void insertRow(User user);

    public List<User> getList();

    User findByUserName(String username);

    public void insertRole(User user);

    public Posts getPost(int id) ;

    public List<Categories> listCategories( );

    public List<Posts> getPostbyCategoria(int id);

    public void insertPost(Posts post) ;

<<<<<<< HEAD
    public List<Coments> getComentsFromPost(int id);

    public void insertComent(Coments coment);


=======
    public Categories getCategories(int id );
>>>>>>> 99ef70e01dc335e6bee1190972dd01ceacaf92d0



}



