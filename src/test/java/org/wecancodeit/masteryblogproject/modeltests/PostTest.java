package org.wecancodeit.masteryblogproject.modeltests;

import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.masteryblogproject.models.Author;
import org.wecancodeit.masteryblogproject.models.Category;
import org.wecancodeit.masteryblogproject.models.Post;
import org.wecancodeit.masteryblogproject.models.Tag;
import org.wecancodeit.masteryblogproject.repositories.AuthorsRepository;
import org.wecancodeit.masteryblogproject.repositories.CategoriesRepository;
import org.wecancodeit.masteryblogproject.repositories.PostsRepository;
import org.wecancodeit.masteryblogproject.repositories.TagsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private PostsRepository posts;
	@Resource
	private CategoriesRepository categories;
	@Resource
	private AuthorsRepository authors;
	@Resource
	private TagsRepository tags;
	
	Category category;
	Author author;
	Tag tag;
	Post post;
	@Before 
	public void setup() {
		categories.save(new Category("Category"));
		authors.save(new Author("Author"));
		tags.save(new Tag("Tag"));
		posts.save(new Post(postId));
		
	}
	
	@Test
	public void shouldGetPostByTitle() {
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();

		Post blogPostFromDatabase = posts.findByTitle("title");

		assertThat(blogPostFromDatabase.getTitle(), Matchers.is("title"));
	}
	


	

}
