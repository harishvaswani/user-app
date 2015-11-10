package com.sample.rest;


import com.oracle.javafx.jmx.json.JSONException;
import com.sample.service.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by harishvaswani on 11/9/15.
 */


@Path("/sample/user")
public class UserRest {

    private UserServiceImpl userService;

    /**
     *
     * @param userService
     */
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     *
     * @return
     */
    public UserServiceImpl getUserService() {
        return userService;
    }

    /**
     *
     * @return
     * @throws JSONException
     */
    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public String showUsers() throws JSONException {
        userService.showUsers();
    }

    /**
     *
     * @param username
     * @return
     * @throws JSONException
     */
    @PUT
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(@QueryParam("username") String username) throws JSONException {
        userService.addUser(username);
    }
}

