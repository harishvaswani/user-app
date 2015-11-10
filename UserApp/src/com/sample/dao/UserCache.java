package com.sample.dao;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by harishvaswani on 11/9/15.
 */

public class UserCache {

    //private static UserCache userCache;
    private static UserCache userCache = new UserCache();
    public static List<String> userNameList = new ArrayList<String>();

    private UserCache() {
    }

    public static UserCache getInstance() {
//        if (userCache == null)
//            userCache = new UserCache();

        return userCache;
    }
}