package com.library.library.DAO;

import com.library.library.model.User;

import java.util.List;

public interface UserDaoInterface {
    public List<User> getAll();

    public User getUser(String id);

    public User addUser(User user);

    public User updateUser(User user, String id);

    public void removeUser(String id);
}
