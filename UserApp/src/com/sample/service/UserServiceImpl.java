package com.sample.service;

import com.sample.dao.UserDao;

import java.util.List;

/**
 * Created by harishvaswani on 11/9/15.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public List<String> showUsers() {
        return userDao.show();
    }

    @Override
    public boolean addUser(String username) {
        return userDao.add(username);
    }
}
