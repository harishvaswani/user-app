package com.sample.dao;

import java.util.List;


/**
 * Created by harishvaswani on 11/9/15.
 */
public interface UserDao {
    List<String> show();
    boolean add(String username);
}
