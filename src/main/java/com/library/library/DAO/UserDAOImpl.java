package com.library.library.DAO;

import com.library.library.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserDAOImpl implements UserDAO {
    private Helper helper = Helper.getInstance();
    private List<User> users = helper.createUserList();
    private static UserDAOImpl instance = null;

    public static UserDAOImpl getInstance() {
        if(instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

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
}
