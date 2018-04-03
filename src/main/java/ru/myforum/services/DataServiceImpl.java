package ru.myforum.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.myforum.dao.DataDao;
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
}
