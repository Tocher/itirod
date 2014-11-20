package com.sprhib.controller;
import com.sprhib.model.Comment;
import com.sprhib.model.Post;
import com.sprhib.model.Tag;
import com.sprhib.service.CommentService;
import com.sprhib.service.PostService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/post/add", method= RequestMethod.GET)
    public ModelAndView addPostPage() {
        ModelAndView modelAndView = new ModelAndView("admin_post_add");
        modelAndView.addObject("post", new Post());
        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags",tags);
        return modelAndView;
    }

    public List<Tag> getTagList(String tags) {
        String[] tagsIds = tags.split(",");
        List<Tag> tagsList = new ArrayList<Tag>();
        for (int i = 0; i < tagsIds.length; i++) {
            tagsList.add(tagService.getTag(Integer.parseInt(tagsIds[i])));
        }
        return tagsList;
    }

    @RequestMapping(value="/post/add", method=RequestMethod.POST)
    public ModelAndView addingPost(Model model,
                                   @RequestParam("name") String name,
                                   @RequestParam("content") String content,
                                   @RequestParam("contentFull") String contentFull,
                                   @RequestParam("tags") String tags) {

        ModelAndView modelAndView = new ModelAndView("admin_post_list");
        Post post = new Post();
        post.setName(name);
        post.setContent(content);
        post.setContentFull(contentFull);
        post.setDate(new Date());
        if(tags != "") {
            post.setTags(getTagList(tags));
        }
        postService.addPost(post);

        List<Post> posts = postService.getPosts();
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @RequestMapping(value="/post/list")
    public ModelAndView listOfPosts() {
        ModelAndView modelAndView = new ModelAndView("admin_post_list");

        List<Post> posts = postService.getPosts();
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @RequestMapping(value="/post/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deletePost(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_post_list");
        postService.deletePost(id);

        List<Post> posts = postService.getPosts();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @RequestMapping(value="/post/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editPostPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_post_edit");
        Post post = postService.getPost(id);
        modelAndView.addObject("post",post);
        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags",tags);
        return modelAndView;
    }

    @RequestMapping(value="/post/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingPost( Model model
                                    , @RequestParam("name") String name
                                    , @RequestParam("content") String content
                                    , @RequestParam("contentFull") String contentFull
                                    , @RequestParam("tags") String tags
                                    , @PathVariable Integer id ) {
        ModelAndView modelAndView = new ModelAndView("admin_post_list");
        Post post = new Post();
        post.setId(id);
        post.setName(name);
        post.setContent(content);
        post.setContentFull(contentFull);
        if(tags != "") {
            post.setTags(getTagList(tags));
        }
        postService.updatePost(post);

        List<Post> posts = postService.getPosts();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }


    // Tags

    @RequestMapping(value="/tag/list")
    public ModelAndView listOfTags() {
        ModelAndView modelAndView = new ModelAndView("admin_tag_list");

        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);

        return modelAndView;
    }

    @RequestMapping(value="/tag/add", method= RequestMethod.GET)
    public ModelAndView addTagPage() {
        ModelAndView modelAndView = new ModelAndView("admin_tag_add");
        modelAndView.addObject("tag", new Tag());
        return modelAndView;
    }

    @RequestMapping(value="/tag/add", method=RequestMethod.POST)
    public ModelAndView addingTag(@ModelAttribute Tag tag) {

        ModelAndView modelAndView = new ModelAndView("admin_tag_list");
        tagService.addTag(tag);

        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);

        return modelAndView;
    }

    @RequestMapping(value="/tag/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTag(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_tag_list");
        tagService.deleteTag(id);

        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }

    @RequestMapping(value="/tag/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTagPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_tag_edit");
        Tag tag = tagService.getTag(id);
        modelAndView.addObject("tag",tag);
        return modelAndView;
    }

    @RequestMapping(value="/tag/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingTag( Model model
            , @RequestParam("name") String name
            , @RequestParam("urlSlug") String urlSlug
            , @PathVariable Integer id ) {
        ModelAndView modelAndView = new ModelAndView("admin_tag_list");
        Tag tag = new Tag();
        tag.setId(id);
        tag.setName(name);
        tag.setUrlSlug(urlSlug);
        tagService.updateTag(tag);

        List<Tag> tags = tagService.getTags();
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }

    // Comments

    @RequestMapping(value="/comment/list")
    public ModelAndView listOfComments() {
        ModelAndView modelAndView = new ModelAndView("admin_comment_list");

        List<Comment> comments = commentService.getComments();
        modelAndView.addObject("comments", comments);

        return modelAndView;
    }

    @RequestMapping(value="/comment/add", method= RequestMethod.GET)
    public ModelAndView addCommentPage() {
        ModelAndView modelAndView = new ModelAndView("admin_comment_add");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @RequestMapping(value="/comment/add", method=RequestMethod.POST)
    public ModelAndView addingComment(@ModelAttribute Comment comment) {

        ModelAndView modelAndView = new ModelAndView("admin_comment_list");
        commentService.addComment(comment);

        List<Comment> comments = commentService.getComments();
        modelAndView.addObject("comments", comments);

        return modelAndView;
    }

    @RequestMapping(value="/comment/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteComment(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_comment_list");
        commentService.deleteComment(id);

        List<Comment> comments = commentService.getComments();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @RequestMapping(value="/comment/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editCommentPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin_comment_edit");
        Comment comment = commentService.getComment(id);
        modelAndView.addObject("comment",comment);
        return modelAndView;
    }

    @RequestMapping(value="/comment/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingComment( Model model
            , @RequestParam("name") String name
            , @RequestParam("content") String content
            , @PathVariable Integer id ) {
        ModelAndView modelAndView = new ModelAndView("admin_comment_list");
        Comment comment = commentService.getComment(id);
        comment.setName(name);
        comment.setContent(content);
        commentService.updateComment(comment);

        List<Comment> comments = commentService.getComments();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

}
