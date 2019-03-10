package org.wecancodeit.masteryblogproject.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.models.Category;
import org.wecancodeit.masteryblogproject.models.Post;
import org.wecancodeit.masteryblogproject.models.Tag;

import org.wecancodeit.masteryblogproject.models.Author;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
@RequestMapping("/post")
public class PostController {

	@Resource
	PostsRepository posts;
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	TagsRepository tags;
	
	
	@GetMapping("/submit")
	public String post(Model model) {
		model.addAttribute("posts", posts.findAll());
		model.addAttribute("authors", authors.findAll());
		model.addAttribute("categories", categories.findAll());
		model.addAttribute("tags", tags.findAll());
		return "submit";
		
	}
	

	@PostMapping("/submit")
	public String postSubmit(Author author, String title, String body, Category progType, Tag[] tagName) {
//		Category categoryToMake = categories.findByProgType(progType);
//		if (categoryToMake == null) {
//			categoryToMake = categories.save(new Category(progType));
//		}
//		categoryToMake = categories.save(categoryToMake);
//		Author authorToMake = authors.findByAuthorName(author);
//		if (authorToMake == null) {
//			authorToMake = authors.save(new Author(author));,
//		}
//		authorToMake = authors.save(authorToMake);
		posts.save(new Post(author, title, body, progType, tagName));
		return "redirect:/";

	}

	@GetMapping("/{postId}")
	public String singlePost(@PathVariable Long postId, Model model) {
		model.addAttribute("post", posts.findById(postId).get());
		model.addAttribute("categories", categories.findAll());
		model.addAttribute("author", authors.findAll());
		model.addAttribute("tags", tags.findAll());
		return "post";
	}
	@PostMapping("/{postId}")
	public String tagSubmit(@PathVariable Long postId, String tagName) {
		Post post = posts.findById(postId).get();
//		Category category = categories.findByProgType(progType);
		
		Tag tag = tags.save(new Tag());
		post.addTag(tag);
		return "/post";
	
	}
}
