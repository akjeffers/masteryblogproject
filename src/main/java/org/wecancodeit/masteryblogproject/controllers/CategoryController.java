package org.wecancodeit.masteryblogproject.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.models.Category;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@RequestMapping("/")
	public String viewCategories(Model model) {
	model.addAttribute("categories", categories.findAll());
	return "/categories/allCategories";
	
}
	@GetMapping("/category/{categoryId}")
	public String findOneCategory (@PathVariable Long categoryId, Model model) {
		Optional<Category> category = categories.findById(categoryId);
		
		model.addAttribute("category", categories.findById(categoryId).get());
		return "categories/singleCategory";
	}
	@PostMapping("/")
	public String addCategory(String progType) {
		Category categoryToAdd = categories.findByProgType(progType);
		if (categoryToAdd == null) {
			categoryToAdd = categories.save(new Category(progType));
		}
		
		return "redirect:/categories/";
		
	}
	
}
