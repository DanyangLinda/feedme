package org.foodie.server.dao;

import javax.transaction.Transactional;
import org.foodie.server.entity.OrderedDish;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface OrderedDishesDao extends CrudRepository<OrderedDish,Long>{
	
}
