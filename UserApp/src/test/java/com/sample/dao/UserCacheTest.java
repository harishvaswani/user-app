package com.sample.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Created by hvaswani on 11/10/2015.
 */
public class UserCacheTest {

    @Test
    public void shouldBeSameInstance() {
        //Clear data
        UserCache.userNameList.clear();
        //Get the first instance
        UserCache cache = UserCache.getInstance();
        //Get another instance
        UserCache anotherCache = UserCache.getInstance();
        assertSame(cache,anotherCache);

        //Adding shouldn't make any difference
        cache.userNameList.add("test");
        assertEquals(1,anotherCache.userNameList.size());
    }
}
