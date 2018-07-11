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
import java.util.List;

@Path("/messages")
@RequestScoped
public class MessageService {
    @Inject
    MessageRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return repo.findAll();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageById(@PathParam("messageId") long messageId) {
        Message message = repo.find(messageId);
        if (message == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return message;
    }

    @GET
    @Path("/thread:{threadId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessagesByThreadId(@PathParam("threadId") int threadId) {
        return repo.findMessagesByThreadId(threadId);
    }

    @GET
    @Path("/user:{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessagesByUserId(@PathParam("userId") int userId) {
        return repo.findMessagesByUserId(userId);
    }
}
