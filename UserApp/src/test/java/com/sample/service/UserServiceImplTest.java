package com.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import com.sample.dao.UserCache;
import com.sample.dao.UserDao;
import com.sample.dao.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by hvaswani on 11/10/2015.
 */
public class UserServiceImplTest {

    private UserDao userDao;

    @Before
    public void runBeforeTests() {
        UserCache.userNameList.clear();
        // Set up data at the DAO layer
        userDao = new UserDaoImpl();
        userDao.add("johnwang");
        userDao.add("maryjane");
    }

    @Test
    public void showUsers() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);

        List<String> usernames = userService.showUsers();
        // assert that the username list is not null
        assertNotNull(usernames);
        // assert that the list has exactly 2 items
        assertEquals(2,usernames.size());
        // assert that the list contains that items that were added in the DAO object
        assertTrue(usernames.contains("johnwang"));
        assertTrue(usernames.contains("maryjane"));
    }

    @Test
    public void addUser() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        List<String> usernames = userService.showUsers();

        // Add a new user and you should have the additional user in the list
        try {
            userService.addUser("newuser");
        } catch (ServiceException se) {
            //It should never get here
            fail();
        }
        assertEquals(3,usernames.size());
        assertTrue(usernames.contains("newuser"));

        //Some edge cases
        //a. Add the same user back and it should not create a new user
        try {
            userService.addUser("newuser");
        } catch (ServiceException se) {
            assertEquals("Username already present: newuser",se.getMessage());
        }
        assertEquals(3,usernames.size());
        assertTrue(usernames.contains("newuser"));
        assertTrue(usernames.contains("johnwang"));
        assertTrue(usernames.contains("maryjane"));

        //b. Add a null object and it shouldn't have any impact on the original list
        try {
            userService.addUser(null);
        } catch (ServiceException se) {
            assertEquals("Username is required",se.getMessage());
        }
        assertEquals(3,usernames.size());
        assertTrue(usernames.contains("newuser"));
        assertTrue(usernames.contains("johnwang"));
        assertTrue(usernames.contains("maryjane"));

        try {
            userService.addUser("");
        } catch (ServiceException se) {
            assertEquals("Username is required",se.getMessage());
        }
        assertEquals(3,usernames.size());
        assertTrue(usernames.contains("newuser"));
        assertTrue(usernames.contains("johnwang"));
        assertTrue(usernames.contains("maryjane"));

        try {
            userService.addUser(" ");
        } catch (ServiceException se) {
            assertEquals("Username is required",se.getMessage());
        }
        assertEquals(3, usernames.size());
        assertTrue(usernames.contains("newuser"));
        assertTrue(usernames.contains("johnwang"));
        assertTrue(usernames.contains("maryjane"));
    }
}
