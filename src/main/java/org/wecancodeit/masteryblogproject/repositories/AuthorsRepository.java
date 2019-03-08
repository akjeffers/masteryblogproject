package org.wecancodeit.masteryblogproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.masteryblogproject.models.Author;

public interface AuthorsRepository extends CrudRepository<Author, Long>{

	Author findByAuthorName(String authorName);
	

}