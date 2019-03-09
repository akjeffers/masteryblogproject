package org.wecancodeit.masteryblogproject;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.masteryblogproject.models.Author;
import org.wecancodeit.masteryblogproject.models.Category;
import org.wecancodeit.masteryblogproject.models.Tag;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@Service
public class Initializer implements CommandLineRunner {
	@Resource
	PostsRepository posts;
	@Resource
	AuthorsRepository authors;
	@Resource
	CategoriesRepository categories;
	@Resource
	TagsRepository tags;
	@Override
	public void run(String... args) throws Exception {
		Category frontEnd = categories.save(new Category("Front End Programming"));
		Category backEnd = categories.save(new Category("Back End Programming"));
		Category fullStack = categories.save(new Category("Full-Stack Development"));
		Author author1 = authors.save(new Author("Jason Hochheiser"));
		Author author2 = authors.save(new Author( "Alicia Jeffers"));
		Tag tag1 = tags.save(new Tag("HTML", null));
		Tag tag2 = tags.save(new Tag("CSS", null));
		Tag tag3 = tags.save(new Tag("JavaScript", null));
		
		
		
		
	}
	
	

}
