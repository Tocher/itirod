package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Post;

public interface PostService {

    public void addPost(Post post);
    public void updatePost(Post post);
    public Post getPost(int id);
    public List<Post> getPostsForPage(int pageNumber, int postsPerPage);
    public void deletePost(int id);
    public List<Post> getPosts();

}
