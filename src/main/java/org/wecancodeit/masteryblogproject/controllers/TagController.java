package org.wecancodeit.masteryblogproject.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.models.Tag;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
@RequestMapping("/tags")
public class TagController {
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@GetMapping ("/tag/{id}")
	public String getSingleTag(@PathVariable Long id, Model model) throws Exception {
		Optional<Tag> tag = tags.findById(id);
		if (tag.isPresent()) {
			model.addAttribute("tag", tag.get());
		} else {
			throw new Exception("The tag you're looking for does not exist");
		}

		return "/tags/singleTag";
}
	@GetMapping("/")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tags.findAll());
		return "/tags/allTags";
		
		
	}
	@PostMapping("/")
	public String addTag(String tagName) {
		Tag tagToAdd = tags.findByTagName(tagName);
		if (tagToAdd == null) {
			tagToAdd = tags.save(new Tag(tagName));
		}
		
		return "redirect:/tags";
		
	}
}
