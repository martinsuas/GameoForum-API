package com.mss.ejb.rest;

import com.mss.ejb.repo.UserRepo;
import com.mss.entity.Token;
import com.mss.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/authentication")
@RequestScoped
public class AuthenticationService implements Serializable {
    private static final Logger LOG = Logger.getLogger(AuthenticationService.class.getName());

    @Inject
    UserRepo repo;

    static final String alphanumeric =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static final long timetolive_seconds =
            60 * 2; // Two minutes for testing purposes

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser (
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        LOG.log(Level.INFO, username + " is attempting to log in.");
        try {
            User user = repo.findByUsername(username);
            authenticate(user, password);
            Token token = createToken(user);
            LOG.log(Level.INFO, "Authentication successful");
            return Response.ok(token).build();
        } catch (Exception e) {
            LOG.log(Level.INFO, "Authentication failed:" + e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(User user, String password) throws Exception {
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Invalid login credentials");
        }
    }

    private Token createToken(User user) {
        // Generate random gen_string
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(30);
        for (int i = 0; i < 30; i++) {
            sb.append(alphanumeric.charAt(sr.nextInt(alphanumeric.length())));
        }
        String gen_string = sb.toString();

        LOG.log(Level.INFO, "Token for " + user.getUsername() + " generated!");
        Token token = new Token();
        token.setUser(user);
        token.setKey(gen_string);
        token.setExpirationTime((System.currentTimeMillis() / 1000L) + timetolive_seconds);

        return token;
    }

}
