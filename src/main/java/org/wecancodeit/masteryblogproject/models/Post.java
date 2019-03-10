package org.wecancodeit.masteryblogproject.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Post {
	

	@Id
	@GeneratedValue
	private Long postId;
	
	@ManyToMany
	private Collection<Author> authors;
	
	@ManyToMany
	private Collection<Tag> tags;
	@Lob
	private String title;
	private LocalDateTime date;
	private String body;
	@ManyToOne
	private Category category;
	
	public Post() {}
	
	public Post(Author authorName, String title, String body, Category category, Tag tags) {
		this.authors = Arrays.asList(authorName);
		this.title = title;
		this.date = LocalDateTime.now();
		this.body = body;
		this.category = category;
		this.tags = Arrays.asList(tags);
	}

	@Override
	public String toString() {
		return "title= " + title + "author=" + authors + ", date=" + date + ", category=" + category + 
				", body=" + body + ", tag=" + tags;
	}
	
	public Long getPostId() {
		return postId;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getDate() {
		return LocalDateTime.now();
	}

	public String getBody() {
		return body;
	}
	public Collection<Tag> getTags() {
		return tags;
	}
	public void addTagToTags(Tag tag) {
		
		tags.add(tag);
		
		
	}
	
	public void addAuthorToAuthors(Author author) {
		
		authors.add(author);
		
		
	}
	

	
}
