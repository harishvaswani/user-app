package com.sample.rest;

import com.google.gson.Gson;
import com.sample.service.ServiceException;
import com.sample.service.UserService;
import com.sample.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by harishvaswani on 11/9/15.
 */

@Path("/user")
public class UserRest {

    private UserService userService;

    /**
     *
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @return
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     *
     * @return
     * @throws
     */
    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showUsers() {
        List<String> usernameList = userService.showUsers();
        return Response.status(Response.Status.OK).entity(
                JSONResponseBuilder.getJSONResponse(Response.Status.OK.toString(),null,usernameList)).build();
    }

    /**
     *
     * @param username
     * @return
     * @throws
     */
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("username") String username) {
        if (username==null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(
                    JSONResponseBuilder.getJSONResponse(Response.Status.BAD_REQUEST.toString(),"Missing query parameter: username",null)).build();
        }
        try {
            userService.addUser(username);
        } catch (ServiceException se) {
            return Response.status(Response.Status.BAD_REQUEST).entity(
                    JSONResponseBuilder.getJSONResponse(Response.Status.BAD_REQUEST.toString(),se.getMessage(),null)).build();
        }
        return Response.status(Response.Status.OK).entity(
                JSONResponseBuilder.getJSONResponse(Response.Status.OK.toString(),"User added successfully",username)).build();
    }
}

