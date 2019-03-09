package org.wecancodeit.masteryblogproject.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	

	@Id
	@GeneratedValue
	private Long postId;
	
	@ManyToMany
	private List<Author> author;
	
	@ManyToMany
	private Collection<Tag> tags;
	@Lob
	private String title;
	private String date;
	private String body;
	@ManyToOne
	private Category category;
	
	public Post() {}
	
	public Post(Author author, String title, String date, String body, Category category, Tag ...tags) {
		this.author = Arrays.asList(author);
		this.title = title;
		this.date = date;
		this.body = body;
		this.category = category;
		this.tags = Arrays.asList(tags);
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", author=" + author + ", tag=" + tags + ", title=" + title + ", date=" + date
				+ ", body=" + body + ", category=" + category + "]";
	}

	public Long getPostId() {
		return postId;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getBody() {
		return body;
	}
	public Collection<Tag> getTag() {
		return tags;
	}
	public void addTag(Tag tag) {
		tags.add(tag);
		
	
	}
	

	
}
