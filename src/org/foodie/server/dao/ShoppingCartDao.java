package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import org.foodie.server.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartDao extends CrudRepository<ShoppingCart, Long> {
	ShoppingCart findOneByUserId(long userId);

}
