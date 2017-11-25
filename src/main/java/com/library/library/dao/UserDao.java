package com.library.library.DAO;

import com.library.library.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserDaoInterface{
    private Helper helper = Helper.getInstance();
    private List<User> users = helper.createUserList();

    @Override
    public List<User> getAll(){
        return users;
    }

    @Override
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

    @Override
    public User addUser(User user){
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user, String id){
        User selectedUser = getUser(id);
        selectedUser.setName(user.getName());
        selectedUser.setAccessLevel(user.getAccessLevel());
        selectedUser.setHasDebt(user.getHasDebt());
        return selectedUser;
    }

    @Override
    public void removeUser(String id){
        User user = getUser(id);
        users.remove(user);
    }
}
