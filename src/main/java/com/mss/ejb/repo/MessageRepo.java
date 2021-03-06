package com.mss.ejb.repo;

import com.mss.entity.Message;
import com.mss.entity.Message_;
import com.mss.entity.Thread;
import com.mss.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class MessageRepo {

    @PersistenceContext
    private EntityManager em;
    private CriteriaBuilder cb;
    private CriteriaQuery<Message> cq;
    private Root<Message> message;

    public Message find(long messageId) {
        return em.find(Message.class, messageId);
    }

    public List<Message> findAll() {
        updateCriteria();
        cq.select(message)
                .orderBy(cb.desc(message.get(Message_.postingTime)));
        return em.createQuery(cq).getResultList();
    }

    public List<Message> findMessagesByThread(Thread thread) {
        updateCriteria();
        cq.select(message)
                .where(cb.equal(message.get(Message_.thread), thread))
                .orderBy(cb.asc(message.get(Message_.postingTime)));
        return em.createQuery(cq).getResultList();
    }

    public List<Message> findMessagesByUser(User user) {
        updateCriteria();
        cq.select(message)
                .where(cb.equal(message.get(Message_.user), user))
                .orderBy(cb.desc(message.get(Message_.postingTime)));
        return em.createQuery(cq).getResultList();
    }

    private void updateCriteria() {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Message.class);
        message = cq.from(Message.class);
    }
}
