package com.library.library.service;

import com.library.library.DAO.UserDao;
import com.library.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll(){
        return userDao.getAll();
    }

    public User getUser(String id){
        return userDao.getUser(id);
    }

    public User addUser(User item){
        return userDao.addUser(item);
    }

    public User updateUser(User item, String id){
        return userDao.updateUser(item, id);
    }

    public void removeUser(String id){
        userDao.removeUser(id);
    }
}
