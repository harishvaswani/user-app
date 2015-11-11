package com.sample.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by hvaswani on 11/10/2015.
 */
public class UserDaoImplTest {
    private UserDao userDao;

    @Before
    public void clearCachedData() {
        UserCache.userNameList.clear();
    }

    @Test
    public void shouldReturnEmptyUserNameList() {
        userDao = new UserDaoImpl();
        List<String> userNameList = userDao.show();
        assertNotNull(userNameList);
        assertEquals(0,userNameList.size());
    }

    @Test
    public void shouldReturnPopulatedUserNameList() {

        userDao = new UserDaoImpl();
        boolean result = userDao.add("test");
        assertTrue(result);

        List<String> userNameList = userDao.show();
        assertNotNull(userNameList);
        assertEquals(1,userNameList.size());
        assertEquals("test",userNameList.get(0));
    }

    @Test
    public void shouldReturnOriginalListWithInvalidInputs() {
        userDao = new UserDaoImpl();
        boolean result = userDao.add("test");
        assertTrue(result);

        //Invalid input 1: dupe username
        result = userDao.add("test");
        assertFalse(result);
        assertEquals(1, userDao.show().size());

        //Invalid input 2: null username
        result = userDao.add(null);
        assertFalse(result);
        assertEquals(1, userDao.show().size());

        //Invalid input 3: empty usernames
        result = userDao.add("");
        assertFalse(result);
        assertEquals(1, userDao.show().size());

        result = userDao.add("  ");
        assertFalse(result);
        assertEquals(1, userDao.show().size());
    }
}
