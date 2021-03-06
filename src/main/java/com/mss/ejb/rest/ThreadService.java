package com.mss.ejb.rest;

import com.mss.ejb.repo.ForumRepo;
import com.mss.ejb.repo.ThreadRepo;
import com.mss.ejb.repo.UserRepo;
import com.mss.entity.Forum;
import com.mss.entity.Thread;
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


@Path("/threads")
@RequestScoped
public class ThreadService {
    @Inject
    ThreadRepo repo;

    @Inject
    UserRepo userRepo;

    @Inject
    ForumRepo forumRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThreads() {
        return Response.ok().entity(repo.findAll()).build();
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThreadById(@PathParam("threadId") int threadId) {
        Thread thread = repo.find(threadId);
        if (thread == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(Collections.singletonList(thread)).build();
    }

    @GET
    @Path("/forum:{forumId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThreadsByForumId(@PathParam("forumId") int forumId)
    {
        Forum forum = forumRepo.find(forumId);
        return Response.ok().entity(repo.findThreadsByForum(forum)).build();
    }

    @GET
    @Path("/user:{userId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThreadsByUserId(@PathParam("userId") int userId)
    {
        User user = userRepo.find(userId);
        return Response.ok().entity(repo.findThreadsByUser(user)).build();
    }
}
