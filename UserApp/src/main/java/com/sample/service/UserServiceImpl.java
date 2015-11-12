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

    /**
     * Returns a list of usernames from the DAO layer
     * @return a list of username strings
     */
    @Override
    public List<String> showUsers() {
        return userDao.show();
    }

    /**
     * @param username - username to add (send to the DAO layer)
     * @return true/false if succeeded/failed
     * @throws ServiceException if adding a duplicate/blank username
     */
    @Override
    public boolean addUser(String username) throws ServiceException {
        if (username==null || username.trim().length()==0) {
            throw new ServiceException("Username is required");
        }
        if (userDao.show().contains(username)) {
            throw new ServiceException("Username already present: "+username);
        }
        return userDao.add(username);
    }
}
