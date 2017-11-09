package com.library.library.dao;

import com.library.library.model.User;

import java.util.List;

public class UserDao {
    private Helper helper = new Helper();
    private List<User> users = helper.createUserList();

    public List<User> getAll(){
        return users;
    }

    public User getUser(String id){
        User selectedUser = null;
        for(User user : users){
            if(user.getId().equals(id)){
                selectedUser = user;
                break;
            }
        }
        return selectedUser;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public User updateUser(User user, String id){
        User selectedUser = getUser(id);
        selectedUser.setName(user.getName());
        selectedUser.setAccessLevel(user.getAccessLevel());
        selectedUser.setHasDebt(user.getHasDebt());
        return selectedUser;
    }

    public void removeUser(String id){
        User user = getUser(id);
        users.remove(user);
    }
}
