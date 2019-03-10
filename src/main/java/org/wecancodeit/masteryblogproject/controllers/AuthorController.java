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
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	PostsRepository posts;
	@Resource
	TagsRepository tags;
	
	@RequestMapping("/")
	public String viewAuthors(Model model) {
	model.addAttribute("authors",authors.findAll());
	return "/authors";
	
}
	@GetMapping("/author/{authorId}")
	public String getAuthor(@PathVariable Long authorId, Model model) throws Exception {
		Optional<Author> author = authors.findById(authorId);
		if (author.isPresent()) {
			model.addAttribute("author", author.get());
		} else {
			throw new Exception("Author does not exist");
		}

		return "/authors/singleAuthor";

	}
	@PostMapping("/")
	public String addAuthor(String authorName) {
		Author authorToAdd = authors.findByAuthorName(authorName);
		if (authorToAdd == null) {
			authorToAdd = authors.save(new Author(authorName));
		}
		
		return "redirect:/authors/";
		
	}
}

