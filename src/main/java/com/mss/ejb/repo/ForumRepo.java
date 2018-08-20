package com.mss.ejb.repo;

import com.mss.entity.Forum;
import com.mss.entity.Forum_;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateful
public class ForumRepo {

    @PersistenceContext
    private EntityManager em;
    private CriteriaBuilder cb;
    private CriteriaQuery<Forum> cq;
    private Root<Forum> forum;

    public Forum find(int forumId) {
        return em.find(Forum.class, forumId);
    }

    public void addForum(Forum forum) {
        em.persist(forum);
    }

    public List<Forum> findAll() {
        updateCriteria();
        cq.select(forum)
                .orderBy(cb.asc(forum.get(Forum_.name)));
        return em.createQuery(cq).getResultList();
    }

    public List<Forum> findRootForums() {
        updateCriteria();
        cq.select(forum)
                .where(cb.equal(forum.get(Forum_.parentId), 0))
                .orderBy(cb.asc(forum.get(Forum_.name)));
        return em.createQuery(cq).getResultList();
    }

    public List<Forum> findSubForums(int forumId) {
        updateCriteria();
        cq.select(forum)
                .where(cb.equal(forum.get(Forum_.parentId), forumId))
                .orderBy(cb.asc(forum.get(Forum_.name)));
        return em.createQuery(cq).getResultList();
    }

    private void updateCriteria() {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Forum.class);
        forum = cq.from(Forum.class);
    }
}
