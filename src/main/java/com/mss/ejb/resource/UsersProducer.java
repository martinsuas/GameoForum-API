package com.mss.ejb.resource;

import com.mss.ejb.repo.UserRepo;
import com.mss.entity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class UsersProducer {
    @Inject
    private UserRepo repo;

    private List<User> users;

    @Produces
    @Named
    public List<User> getUsers() {
        return users;
    }

    public void onChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final User user) {
        retrieveAllOrderedName();
    }

    @PostConstruct
    private void retrieveAllOrderedName(){
        users = repo.findAll();
    }
}
