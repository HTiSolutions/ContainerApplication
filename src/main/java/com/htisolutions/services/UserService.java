package com.htisolutions.services;

import com.htisolutions.entities.User;
import com.htisolutions.entities.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Iterable<User> getUsers() {
        Iterable<User> users = userDao.findAll();

        return users;
    }

    public void addUser(String forename, String surname) {
        User user  = new User(forename, surname);
        userDao.save(user);
    }
}
