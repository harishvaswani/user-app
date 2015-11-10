package com.sample.service;

import java.util.List;

/**
 * Created by harishvaswani on 11/9/15.
 */
public interface UserService {
    List<String> showUsers();
    boolean addUser(String username);
}
