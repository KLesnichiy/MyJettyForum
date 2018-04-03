package ru.myforum.services;

import ru.myforum.model.User;

import java.util.List;
/**
 * Created by Шмель on 14.12.2017.
 */
public interface DataService {
    public void insertRow(User user);

    public List<User> getList();

    public User findByUserName(String username);

}
