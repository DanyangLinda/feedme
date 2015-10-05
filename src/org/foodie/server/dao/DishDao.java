package org.foodie.server.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.foodie.server.entity.Dish;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Danyang Li
 *
 */
@Transactional
public interface DishDao extends CrudRepository<Dish,Long> {

	List<Dish> findByShopId(long shopId);
	Dish findOneById(long id);

}


