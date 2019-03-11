package org.wecancodeit.masteryblogproject.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.masteryblogproject.models.Author;
import org.wecancodeit.masteryblogproject.models.Category;
import org.wecancodeit.masteryblogproject.models.Post;
import org.wecancodeit.masteryblogproject.models.Tag;
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
	public String allPosts(Model model) {
		model.addAttribute("posts", posts.findAll());
		model.addAttribute("authors", authors.findAll());
		model.addAttribute("categories", categories.findAll());
		model.addAttribute("tags", tags.findAll());
		return "submit";
		
	}
	

	@PostMapping("/submit")
	public String postSubmit(String authorName, String title, String body, String progType, String tagName) {
		Category category = categories.findByProgType(progType);
		Author author = authors.findByAuthorName(authorName);
		Tag tag = tags.findByTagName(tagName);
		posts.save(new Post(author, title, body, category, tag));
		return "redirect:/";

	}

	@GetMapping("/{postId}")
	public String singlePost(@PathVariable Long postId, Model model) throws Exception {
		model.addAttribute("posts", posts.findAll());
		model.addAttribute("authors", authors.findAll());
		model.addAttribute("categories", categories.findAll());
		model.addAttribute("tags", tags.findAll());
		Optional<Post> post = posts.findById(postId);
		if(post.isPresent()) {
			model.addAttribute("post", post.get());
		} else {
			throw new Exception("Post does not exist");
		}
		return "post";
		
	}
	@PostMapping("/{postId}")
	public String tagSubmit(@PathVariable Long postId, String tagName) {	
		Post post = posts.findById(postId).get();
		Tag tag = tags.save(new Tag());
		post.addTagToTags(tag);
		return "redirect:/post/";
	
	}
	
	
}
