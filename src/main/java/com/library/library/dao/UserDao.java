package com.library.library.DAO;

import com.library.library.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    User getUser(String id);

    User addUser(User user);

    User updateUser(User user, String id);
}
