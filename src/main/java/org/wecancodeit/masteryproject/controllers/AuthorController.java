package org.wecancodeit.masteryproject.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {
	
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@RequestMapping("")
	public String viewAuthor(Model model) {
	model.addAttribute("authors",authors.findAll());
	return "/author";
	
}
	@GetMapping("/{authorId}")
	public String findOneAuthor (@PathVariable Long authorId, Model model) {
		model.addAttribute("author", authors.findById(authorId).get());
		model.addAttribute("authors", authors.findAll());
		return "author";
	}
}
