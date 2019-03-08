package org.wecancodeit.masteryblogproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long postId;
	
	@ManyToOne
	private Author author;
	@Lob
	private String title;
	private String date;
	private String body;
	
	public Post() {}
	
	public Post(Author author, String title, String date, String body) {
		this.author = author;
		this.title = title;
		this.date = date;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", author=" + author + ", title=" + title + ", date=" + date + ", body="
				+ body + "]";
	}

	public Long getPostId() {
		return postId;
	}

	public Author getAuthor() {
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
	

	
}
