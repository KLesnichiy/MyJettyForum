package ru.myforum.dao;

import ru.myforum.model.User;

import java.util.List;

/**
 * Created by Шмель on 14.12.2017.
 */
public interface DataDao {


    public void insertRow(User user);

    public List<User> getList();

    public User findByUserName(String username);



}



