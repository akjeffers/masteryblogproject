package org.wecancodeit.masteryblogproject.controllers;

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
@RequestMapping("/category")
public class CategoryController {
	
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@RequestMapping("")
	public String viewCategory(Model model) {
	model.addAttribute("categories", categories.findAll());
	return "/category";
	
}
	@GetMapping("/{categoryId}")
	public String findOneCategory (@PathVariable Long categoryId, Model model) {
		model.addAttribute("category", categories.findById(categoryId).get());
		model.addAttribute("categories", categories.findAll());
		return "category";
	}
	
}

