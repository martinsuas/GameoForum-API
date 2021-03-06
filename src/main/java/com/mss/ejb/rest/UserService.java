package com.mss.ejb.rest;

import com.mss.ejb.repo.UserRepo;
import com.mss.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("/users")
@RequestScoped
public class UserService {

    @Inject
    UserRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok().entity(repo.findAll()).build();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") int userId) {
        User user = repo.find(userId);
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(Collections.singletonList(user)).build();
    }

    @GET
    @Path("/{username:" + User.USERNAME_REGEX + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername(@PathParam("username") String username) {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(Collections.singletonList(user)).build();
    }
}
