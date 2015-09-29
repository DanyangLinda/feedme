package org.foodie.server.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.foodie.server.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Danyang Li
 *
 */
@Transactional
public interface OrderDao extends CrudRepository<Order,Long> {
	
	List<Order> findByUserId(long userId);
	

}
