package org.wecancodeit.masteryblogproject.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private Long authorId;
	private String authorName;
	@ManyToMany(mappedBy="author")
	private Collection<Post> posts;
	
	public Author () {}
	
	public Author(String authorNames) {
		this.authorName = authorNames;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

	public Long getAuthorId() {
		return authorId;
	}

	public String getAuthorName() {
		return authorName;
	}
	public String getAuthorNames() {
		return authorName;
	}
	public Collection<Post> getPosts() {
		return posts;
	}
	
	

}
