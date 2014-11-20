package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Comment;

public interface CommentService {

    public void addComment(Comment post);
    public void updateComment(Comment post);
    public Comment getComment(int id);
    public void deleteComment(int id);
    public List<Comment> getComments();

}
