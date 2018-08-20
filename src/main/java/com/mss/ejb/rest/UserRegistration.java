package com.mss.ejb.rest;

import com.mss.entity.User;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRegistration {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<User> userEvent;

    public void register(User user) throws Exception {
        em.persist(user);
        userEvent.fire(user);
    }
}
