package com.sample.service;

import java.util.List;

/**
 * Created by harishvaswani on 11/9/15.
 */
public interface UserService {
    public List<String> showUsers();
    public boolean addUser(String username) throws ServiceException;
}
