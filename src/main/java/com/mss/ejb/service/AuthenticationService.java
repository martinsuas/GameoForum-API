package com.mss.ejb.service;


import com.mss.ejb.repo.TokenRepo;
import com.mss.ejb.repo.UserRepo;
import com.mss.entity.Token;
import com.mss.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/authentication")
public class AuthenticationService {
    private static final Logger LOG = Logger.getLogger(AuthenticationService.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserRepo repo;

    @Inject
    TokenRepo tkrep;

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
        try {
            User user = repo.findByUsername(username);
            authenticate(user, password);
            Token token = createToken(user);

            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(User user, String password) throws Exception {
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Invalid login credentials");
        }
    }

    private Token createToken(User user) {
        String gen_string;
        while(true) {
            // Generate random gen_string
            SecureRandom sr = new SecureRandom();
            StringBuilder sb = new StringBuilder(30);
            for (int i = 0; i < 30; i++) {
                sb.append(alphanumeric.charAt(sr.nextInt(alphanumeric.length())));
            }
            gen_string = sb.toString();

            // We keep looping until a unique gen_string is produced.
            // Very UNLIKELY that it would ever happen
            // @TODO - Reconsider if it would matter if two users by some miracle end up w same token
            if (tkrep.find(gen_string) == null)
                break;

            // In case of a match, there might be something wrong with our string
            // generator. Let's log it.
            LOG.log(Level.SEVERE, "What are the chances of a collision!?");
        }
        Token token = new Token();
        token.setUser(user);
        token.setKey(gen_string);
        token.setExpirationTime((System.currentTimeMillis() / 1000L) + timetolive_seconds);

        em.persist(token);

        return token;
    }

}
