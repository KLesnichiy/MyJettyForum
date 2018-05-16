package ru.myforum.services;

import ru.myforum.model.Categories;
import ru.myforum.model.Coments;
import ru.myforum.model.Posts;
import ru.myforum.model.User;

import java.util.List;
/**
 * Created by Шмель on 14.12.2017.
 */
public interface DataService {
    public void insertRow(User user);

    public List<User> getList();

    User findByUserName(String username);

    public void insertRole(User user);

    public Posts getPost(int id) ;

    public List<Categories> listCategories( );

    public List<Posts> getPostbyCategoria(int id);

    public void insertPost(Posts post) ;



    public List<Coments> getComentsFromPost(int id);

    public void insertComent(Coments coment);



}
