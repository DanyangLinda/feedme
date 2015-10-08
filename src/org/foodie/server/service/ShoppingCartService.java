package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import org.foodie.server.entity.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
	void saveCart(ShoppingCart cart);
	ShoppingCart queryCart(long userId);
}
