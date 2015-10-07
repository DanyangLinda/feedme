package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.dao.DishDao;
import org.foodie.server.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishServiceImp implements DishService {
	@Autowired
	private DishDao dishDao;
	
	@Override
	public void create(Dish newDish){
		dishDao.save(newDish);
	}

	@Override
	public void remove(Dish removedDish) {
		dishDao.delete(removedDish);
		
	}

	@Override
	public void update(Dish updatedDish) {
		dishDao.save(updatedDish);
		
	}

	@Override
	public List<Dish> query(long shop_id) {
		return dishDao.findByShopId(shop_id);
	}

	@Override
	public Dish queryOne(long dishId) {
		return dishDao.findOneById(dishId);
	}
}	
