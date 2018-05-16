package com.lisotti.topic3.service;


import com.lisotti.topic3.model.User;
import com.lisotti.topic3.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class UserService {

    @Autowired
    UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public void register(User user) {
        this.userRepo.save(user);
    }

    public List<User> getAll() {

        return this.userRepo.getAll();
    }

    public User getById(int id) {

        return this.userRepo.getById(id);
    }

    public User getByUsername(String username)
    {
        return this.userRepo.getByUsername(username);
    }

    public void updateById(int id, User u)
    {
        this.userRepo.save(u);
    }

    public void deleteById(int id) {

        this.userRepo.removeById(id);
    }

}
