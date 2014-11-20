package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

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
    public void addComment(Comment comment) {
        getCurrentSession();
        session.save(comment);
        tx.commit();
    }

    public void updateComment(Comment comment) {
        Comment CommentToUpdate = getComment(comment.getId());
        CommentToUpdate.setName(comment.getName());
        CommentToUpdate.setContent(comment.getContent());
        CommentToUpdate.setDate(comment.getDate());
        CommentToUpdate.setPost(comment.getPost());
        getCurrentSession();
        session.update(CommentToUpdate);
        tx.commit();
    }

    public Comment getComment(int id) {
        getCurrentSession();
        Comment comment = (Comment) session.get(Comment.class, id);
        tx.commit();
        return comment;
    }

    public void deleteComment(int id) {
        Comment comment = getComment(id);
        if (comment != null) {
            getCurrentSession();
            session.delete(comment);
            tx.commit();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Comment> getComments() {
        getCurrentSession();
        List<Comment> comments = session.createQuery("from com.sprhib.model.Comment").list();
        tx.commit();
        return comments;
    }

}
