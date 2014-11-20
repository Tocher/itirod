package com.sprhib.controller;
import com.sprhib.model.Comment;
import com.sprhib.model.Post;
import com.sprhib.service.CommentService;
import com.sprhib.service.PostService;
import com.sprhib.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Users;

import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private PostService postService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CommentService commentService;

	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("/admin**")
	public ModelAndView getAdminProfile() {
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("postCount", postService.getPosts().size());
		modelAndView.addObject("tagCount", tagService.getTags().size());
		modelAndView.addObject("commentCount", commentService.getComments().size());
		return modelAndView;
	}

	@RequestMapping("/user**")
	public String getUserProfile() {
		return "user";
	}

	@RequestMapping("/403")
	public ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		}

		return new ModelAndView("403", "username", username);
	}

}
