package com.sprhib.controller;

import com.sprhib.model.Post;
import com.sprhib.model.Tag;
import com.sprhib.service.PostService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/tag")
public class TagController {

    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value="/{urlSlug}", method= RequestMethod.GET)
    public ModelAndView ViewPost(@PathVariable String urlSlug) {
        ModelAndView modelAndView = new ModelAndView("tag/view");
        Tag tag = tagService.getTagBySlug(urlSlug);
        modelAndView.addObject("tag", tag);

        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }
}