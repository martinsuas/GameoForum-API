package com.mss.ejb.rest;

import com.mss.ejb.repo.ForumRepo;
import com.mss.entity.Forum;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/forums")
@RequestScoped
public class ForumService {
    private static final Logger LOG = Logger.getLogger(ForumService.class.getName());

    @Inject
    ForumRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForums() {
        return Response.ok().entity(repo.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createForum(
            @FormParam("parentId") int parentId,
            @FormParam("name") String name,
            @FormParam("description") String description
    ) {
        try {
            Forum forum = new Forum();
            forum.setParentId(parentId);
            forum.setDescription(description);
            forum.setName(name);
            repo.addForum(forum);
            return Response.ok(forum).build();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.toString());
            return Response.serverError().build();
        }

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
