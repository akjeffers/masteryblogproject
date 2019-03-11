package org.wecancodeit.masteryblogproject.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.models.Post;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
public class HomeController {

	@Resource
	PostsRepository posts;
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	TagsRepository tags;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("posts", posts.findAll());
		model.addAttribute("authors", authors.findAll());
		model.addAttribute("categories", categories.findAll());
		model.addAttribute("tags", tags.findAll());
		return "home";
	}

	


	@PostMapping("/deletePost")
	public String deletePost(Long postId) {
		Post post = (Post) posts.findById(postId).get();
		posts.deleteById(postId);
		return "redirect:/";
	}
}
