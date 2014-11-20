package com.sprhib.controller;

import com.sprhib.model.Comment;
import com.sprhib.model.Post;
import com.sprhib.model.Tag;
import com.sprhib.service.CommentService;
import com.sprhib.service.PostService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/add/{postId}", method= RequestMethod.POST)
    public ModelAndView ViewPost(@RequestParam("name") String name,
                                 @RequestParam("content") String content,
                                 @PathVariable int postId) {
        Comment comment = new Comment();
        comment.setName(name);
        comment.setContent(content);
        comment.setDate(new Date());
        Post post = postService.getPost(postId);
        comment.setPost(post);
        List<Comment> coms = post.getComments();
        coms.add(comment);
        post.setComments(coms);
        postService.updatePost(post);
        commentService.addComment(comment);

        ModelAndView modelAndView = new ModelAndView("post/view");
        modelAndView.addObject("post", post);
        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);
        modelAndView.addObject("comment", new Comment());

        return modelAndView;
    }
}
