package com.mss.ejb.repo;

import com.mss.entity.User;
import com.mss.entity.User_;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class UserRepo {

    @PersistenceContext
    private EntityManager em;
    private CriteriaBuilder cb;
    private CriteriaQuery<User> cq;
    private Root<User> user;

    public User find(int userId) {
        return em.find(User.class, userId);
    }

    public List<User> findAll() {
        updateCriteria();
        cq.select(user)
                .orderBy(cb.asc(user.get(User_.username)));
        return em.createQuery(cq).getResultList();
    }

    public User findByUsername(String username) {
        updateCriteria();
        cq.select(user)
                .where(cb.equal(user.get(User_.username), username));
        return em.createQuery(cq).getSingleResult();
    }

    private void updateCriteria() {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(User.class);
        user = cq.from(User.class);
    }
}
