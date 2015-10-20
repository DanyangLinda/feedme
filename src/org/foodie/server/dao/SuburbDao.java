package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.entity.Suburb;
import org.springframework.data.repository.CrudRepository;

public interface SuburbDao extends CrudRepository<Suburb, Long> {
	List<Suburb> findByStateId(long id);
}
