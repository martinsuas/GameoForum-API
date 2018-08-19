package com.mss.ejb.repo;

import com.mss.entity.Token;
import com.mss.entity.Token_;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@ApplicationScoped
public class TokenRepo {

    @PersistenceContext
    private EntityManager em;

    public Token find(int userId) {
        return em.find(Token.class, userId);
    }

    public Token find(String key) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Token> cq = cb.createQuery(Token.class);
        Root<Token> token = cq.from(Token.class);
        cq.select(token)
                .where(cb.equal(token.get(Token_.key), key));
        return em.createQuery(cq).getSingleResult();
    }
}
