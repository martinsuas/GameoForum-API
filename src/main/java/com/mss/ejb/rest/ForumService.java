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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/forums")
@RequestScoped
public class ForumService {
    @Inject
    ForumRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Forum> getForums() {
        return repo.findAll();
    }

    @GET
    @Path("/{forumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Forum getForumById(@PathParam("forumId") int forumId) {
        Forum forum = repo.find(forumId);
        if (forum == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return forum;
    }

    @GET
    @Path("/root")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Forum> getRootForums() {
        return repo.findRootForums();
    }

    @GET
    @Path("/{forumId}:children")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Forum> getChildForums(@PathParam("forumId") int forumId) {
        return repo.findSubForums(forumId);
    }
}
