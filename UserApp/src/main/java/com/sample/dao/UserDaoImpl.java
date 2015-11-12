package com.sample.dao;

import java.util.List;

/**
 * Created by harishvaswani on 11/9/15.
 */
public class UserDaoImpl implements UserDao {

    /**
     * Shows a list of usernames from a cached list
     * @return list of username strings
     */
    @Override
    public List<String> show() {
        return UserCache.userNameList;
    }

    /**
     * Adds a username to a cached list
     * @param username - username to add
     * @return true/false is succeeded/failed
     */
    @Override
    public boolean add(String username) {
        if (username!=null && username.trim().length() != 0
                && !UserCache.userNameList.contains(username)) {
            UserCache.userNameList.add(username);
            return true;
        }
        return false;
    }
}

