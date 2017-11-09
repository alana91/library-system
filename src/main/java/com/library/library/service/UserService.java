package com.library.library.service;

import com.library.library.dao.UserDao;
import com.library.library.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {
    UserDao userDao = new UserDao();

    public List<User> getAll(){
        return userDao.getAll();
    }

    public User getUser(String id){
        return userDao.getUser(id);
    }

    public User addUser(User item){
        item.setId();
        return userDao.addUser(item);
    }

    public User updateUser(User item, String id){
        return userDao.updateUser(item, id);
    }

    public void removeUser(String id){
        userDao.removeUser(id);
    }
}
