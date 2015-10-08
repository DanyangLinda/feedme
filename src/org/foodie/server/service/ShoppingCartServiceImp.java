package org.foodie.server.service;
import org.foodie.server.dao.ShoppingCartDao;
/**
 * @author Danyang Li
 */
import org.foodie.server.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartServiceImp implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao cartDao;
	
	@Override
	public void saveCart(ShoppingCart cart) {
		cartDao.save(cart);
	}

	@Override
	public ShoppingCart queryCart(long userId) {
		return cartDao.findOneByUserId(userId);
	}

}
