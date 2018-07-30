package com.mss.ejb.repo;


import com.mss.entity.Forum;
import com.mss.entity.Thread;
import com.mss.entity.Thread_;
import com.mss.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class ThreadRepo {

    @PersistenceContext
    private EntityManager em;
    private CriteriaBuilder cb;
    private CriteriaQuery<Thread> cq;
    private Root<Thread> thread;


    public Thread find(int threadId) {
        return em.find(Thread.class, threadId);
    }

    public List<Thread> findAll() {
        updateCriteria();
        cq.select(thread)
                .orderBy(cb.desc(thread.get(Thread_.creationTime)));
        return em.createQuery(cq).getResultList();
    }

    public List<Thread> findThreadsByForum(Forum forum) {
        updateCriteria();
        cq.select(thread)
                .where(cb.equal(thread.get(Thread_.forum), forum))
                .orderBy(cb.desc(thread.get(Thread_.creationTime)));
        return em.createQuery(cq).getResultList();
    }

    public List<Thread> findThreadsByUser(User user) {
        updateCriteria();
        cq.select(thread)
                .where(cb.equal(thread.get(Thread_.user), user))
                .orderBy(cb.desc(thread.get(Thread_.creationTime)));
        return em.createQuery(cq).getResultList();
    }

    private void updateCriteria() {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Thread.class);
        thread = cq.from(Thread.class);
    }
}
