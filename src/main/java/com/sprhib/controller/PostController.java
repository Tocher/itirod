package com.sprhib.controller;

import java.util.List;

import com.sprhib.model.Comment;
import com.sprhib.model.Tag;
import com.sprhib.service.CommentService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Post;
import com.sprhib.service.PostService;

@Controller
@RequestMapping(value="/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView ViewPost(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("post/view");
        Post post = postService.getPost(id);
        modelAndView.addObject("post", post);
        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
}
