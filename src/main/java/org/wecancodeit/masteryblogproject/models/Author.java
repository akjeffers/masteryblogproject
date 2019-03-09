package org.wecancodeit.masteryblogproject.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private Long authorId;
	private Author authorName;
	@ManyToMany(mappedBy="author")
	private Collection<Post> posts;
	
	public Author () {}
	
	public Author(Author author) {
		this.authorName = author;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

	public Long getAuthorId() {
		return authorId;
	}

	public Author getAuthorName() {
		return authorName;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	

}
