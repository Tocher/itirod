package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.CommentDAO;
import com.sprhib.model.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    public void addComment(Comment post) {
        commentDAO.addComment(post);
    }

    public void updateComment(Comment post) {
        commentDAO.updateComment(post);
    }

    public Comment getComment(int id) {
        return commentDAO.getComment(id);
    }

    public void deleteComment(int id) {
        commentDAO.deleteComment(id);
    }

    public List<Comment> getComments() {
        return commentDAO.getComments();
    }

}
