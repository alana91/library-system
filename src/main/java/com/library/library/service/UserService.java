package com.library.library.service;

import com.library.library.DAO.UserDAOImpl;
import com.library.library.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public final class UserService {

    private static UserService instance = null;

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserDAOImpl userDaoImpl = UserDAOImpl.getInstance();

    public List<User> getAll(){
        return userDaoImpl.getAll();
    }

    public User getUser(String id){
        return userDaoImpl.getUser(id);
    }

    public User addUser(User item){
        return userDaoImpl.addUser(item);
    }

    public User updateUser(User item, String id){
        return userDaoImpl.updateUser(item, id);
    }
}
