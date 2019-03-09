package org.wecancodeit.masteryblogproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.masteryblogproject.models.Post;

public interface PostsRepository extends CrudRepository<Post, Long>{

	Post save(Post post);

}
