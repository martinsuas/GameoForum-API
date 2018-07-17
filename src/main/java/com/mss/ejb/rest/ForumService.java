package com.mss.ejb.rest;

import com.mss.ejb.repo.ForumRepo;
import com.mss.entity.Forum;

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

@Path("/forums")
@RequestScoped
public class ForumService {
    @Inject
    ForumRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForums() {
        return Response.ok().entity(repo.findAll()).build();
    }

    @GET
    @Path("/{forumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForumById(@PathParam("forumId") int forumId) {
        Forum forum = repo.find(forumId);
        if (forum == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(Collections.singletonList(forum)).build();
    }

    @GET
    @Path("/root")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRootForums() {
        return Response.ok().entity(repo.findRootForums()).build();
    }

    @GET
    @Path("/{forumId}:children")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChildForums(@PathParam("forumId") int forumId) {
        return Response.ok().entity(repo.findSubForums(forumId)).build();
    }
}
