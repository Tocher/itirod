package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Post;

@Repository
public class PostDAOImpl implements PostDAO {

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

    public void addPost(Post post) {
        getCurrentSession();
        session.save(post);
        tx.commit();
    }

    public void updatePost(Post post) {
        Post postToUpdate = getPost(post.getId());
        postToUpdate.setName(post.getName());
        postToUpdate.setContent(post.getContent());
        postToUpdate.setContentFull(post.getContentFull());
        postToUpdate.setTags(post.getTags());
        getCurrentSession();
        session.update(postToUpdate);
        tx.commit();
    }

    public Post getPost(int id) {
        getCurrentSession();
        Post post = (Post) session.get(Post.class, id);
        tx.commit();
        return post;
    }


    @SuppressWarnings("unchecked")
    public List<Post> getPostsForPage(int pageNumber, int postsPerPage) {
        getCurrentSession();
        List<Post> posts = session.createQuery("from com.sprhib.model.Post order by 'date' desc")
                .setFirstResult((pageNumber - 1) * postsPerPage)
                .setMaxResults(postsPerPage)
                .list();
        tx.commit();
        return posts;
    }

    public void deletePost(int id) {
        Post post = getPost(id);
        if (post != null) {
            getCurrentSession();
            session.delete(post);
            tx.commit();
        }
    }

    public List<Post> getPosts() {
        getCurrentSession();
        List<Post> posts = session.createQuery("from com.sprhib.model.Post").list();
        tx.commit();
        return posts;
    }

}
