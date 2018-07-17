package com.mss.ejb.rest;

import com.mss.ejb.repo.MessageRepo;
import com.mss.entity.Message;

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

@Path("/messages")
@RequestScoped
public class MessageService {
    @Inject
    MessageRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        return Response.ok().entity(repo.findAll()).build();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("messageId") long messageId) {
        Message message = repo.find(messageId);
        if (message == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().entity(Collections.singletonList(message)).build();
    }

    @GET
    @Path("/thread:{threadId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessagesByThreadId(@PathParam("threadId") int threadId) {
        return Response.ok().entity(repo.findMessagesByThreadId(threadId)).build();
    }

    @GET
    @Path("/user:{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessagesByUserId(@PathParam("userId") int userId) {
        return Response.ok().entity(repo.findMessagesByUserId(userId)).build();
    }
}
