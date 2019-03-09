package org.wecancodeit.masteryblogproject.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long categoryId;
	private String progType;
	@ManyToOne
	private Collection<Post> posts;
	
	public Category() {}
	
	public Category(String progType) {
		this.progType = progType;
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", progType=" + progType + "]";
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getProgType() {
		return progType;
	}

}
