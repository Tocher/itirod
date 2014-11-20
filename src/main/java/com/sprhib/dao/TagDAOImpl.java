package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Tag;

@Repository
public class TagDAOImpl implements TagDAO {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private void getCurrentSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        tx = session.getTransaction();
        session.beginTransaction();
    }

    public void addTag(Tag tag) {
        getCurrentSession();
        session.save(tag);
        tx.commit();
    }

    public void updateTag(Tag tag) {
        Tag tagToUpdate = getTag(tag.getId());
        tagToUpdate.setName(tag.getName());
        tagToUpdate.setUrlSlug(tag.getUrlSlug());
        getCurrentSession();
        session.update(tagToUpdate);
        tx.commit();
    }

    public Tag getTag(int id) {
        getCurrentSession();
        Tag tag = (Tag) session.get(Tag.class, id);
        tx.commit();
        return tag;
    }

    public Tag getTagBySlug(String slug) {
        getCurrentSession();
        Tag tag = (Tag) session.createCriteria(Tag.class)
                .add(Restrictions.eq("urlSlug", slug))
                .uniqueResult();
        tx.commit();
        return tag;
    }

    public void deleteTag(int id) {
        Tag tag = getTag(id);
        if (tag != null) {
            getCurrentSession();
            session.delete(tag);
            tx.commit();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Tag> getTags() {
        getCurrentSession();
        List<Tag> tags = session.createQuery("from com.sprhib.model.Tag").list();
        tx.commit();
        return tags;
    }

}
