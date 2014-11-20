package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Comment;

public interface CommentDAO {

    public void addComment(Comment comment);
    public void updateComment(Comment comment);
    public Comment getComment(int id);
    public void deleteComment(int id);
    public List<Comment> getComments();

}
