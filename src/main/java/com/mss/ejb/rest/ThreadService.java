package com.mss.ejb.rest;

import com.mss.ejb.repo.ThreadRepo;
import com.mss.entity.Thread;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/threads")
@RequestScoped
public class ThreadService {
    @Inject
    ThreadRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Thread> getThreads() {
        return repo.findAll();
    }

    @GET
    @Path("/{threadId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Thread getThreadById(@PathParam("threadId") int threadId) {
        Thread thread = repo.find(threadId);
        if (thread == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return thread;
    }

    @GET
    @Path("/forum:{forumId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Thread> getThreadsByForumId(@PathParam("forumId") int forumId)
    {
        return repo.findThreadsByForumId(forumId);
    }

    @GET
    @Path("/user:{userId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Thread> getThreadsByUserId(@PathParam("userId") int userId)
    {
        return repo.findThreadsByUserId(userId);
    }
}
