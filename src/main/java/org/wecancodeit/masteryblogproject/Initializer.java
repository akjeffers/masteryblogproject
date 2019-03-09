package org.wecancodeit.masteryblogproject;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.masteryblogproject.models.Category;
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
		
		
		
	}
	
	

}
