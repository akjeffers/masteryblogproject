package org.wecancodeit.masteryblogproject.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
public class TagController {
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@GetMapping ("/{id}")
	public String singleTag(@PathVariable Long id, Model model) {
		model.addAttribute("post", posts.findAll());
		model.addAttribute("tag", tags.findById(id).get());
		return "/tag";
	}
}
