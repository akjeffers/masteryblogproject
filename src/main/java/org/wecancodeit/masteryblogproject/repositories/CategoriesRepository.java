package org.wecancodeit.masteryblogproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.masteryblogproject.models.Category;

public interface CategoriesRepository extends CrudRepository<Category, Long>{



	Category findByProgType(String progType);
	

	



}
