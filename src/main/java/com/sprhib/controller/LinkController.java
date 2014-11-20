package com.sprhib.controller;

import com.sprhib.model.Post;
import com.sprhib.model.Tag;
import com.sprhib.service.PostService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LinkController {

	@Autowired
	private PostService postService;
	@Autowired
	private TagService tagService;
	private int POST_PER_PAGE = 5;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("prevPage", 0);
		if (postService.getPosts().size() > POST_PER_PAGE)
			modelAndView.addObject("nextPage", 2);
		List<Post> posts = postService.getPostsForPage(1, POST_PER_PAGE);
		modelAndView.addObject("posts", posts);
		List<Tag> tags = tagService.getTags();
		modelAndView.addObject("tags", tags);
		return modelAndView;
	}

	@RequestMapping(value = { "/page/{page}", "/home/{page}", "/index/{page}" })
	public ModelAndView otherPage(@PathVariable Integer page) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Post> posts = postService.getPostsForPage(page, POST_PER_PAGE);
		modelAndView.addObject("prevPage", page-1);
		if (postService.getPosts().size() > POST_PER_PAGE*page)
			modelAndView.addObject("nextPage", page+1);
		else
			modelAndView.addObject("nextPage", 0);
		modelAndView.addObject("posts", posts);
		List<Tag> tags = tagService.getTags();
		modelAndView.addObject("tags", tags);
		return modelAndView;
	}

	@RequestMapping(value = { "/popular" })
	public ModelAndView popularPage() {
		ModelAndView modelAndView = new ModelAndView("popular");
		List<Post> posts = postService.getPosts();
		List<Post> pposts = new ArrayList<>();
		for (int i = 0; i < posts.size(); i++) {
			System.out.println("Coms:"+posts.get(i).getComments().size());
			if(posts.get(i).getComments().size() > 0) {
				pposts.add(posts.get(i));
			}
		}
		modelAndView.addObject("posts", pposts);
		List<Tag> tags = tagService.getTags();
		modelAndView.addObject("tags", tags);
		return modelAndView;
	}
}
