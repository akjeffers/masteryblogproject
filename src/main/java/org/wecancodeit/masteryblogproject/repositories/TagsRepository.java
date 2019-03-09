package org.wecancodeit.masteryblogproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.masteryblogproject.models.Tag;

public interface TagsRepository extends CrudRepository<Tag, Long>{

	Tag save(Tag tag);

	Tag findByTagName(String tagName);
	

}
