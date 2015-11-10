package com.sample.dao;

import java.util.List;

/**
 * Created by harishvaswani on 11/9/15.
 */
public class UserDaoImpl implements UserDao {


    @Override
    public List<String> show() {
        return UserCache.userNameList;
    }

    @Override
    public boolean add(String username) {
        UserCache.userNameList.add(username);
        return true;
    }
}

