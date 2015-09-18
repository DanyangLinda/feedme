package org.foodie.server.service;

import java.util.List;

import org.foodie.server.dao.RestaurantDao;
import org.foodie.server.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class RestaurantServiceImp implements RestaurantService {
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public void create(Restaurant newRestaurant) {
		restaurantDao.save(newRestaurant);
		
	}

	@Override
	public void remove(Restaurant removedRestaurant) {
		restaurantDao.delete(removedRestaurant);
		
	}

	@Override
	public void update(Restaurant updatedRestaurant) {
		restaurantDao.save(updatedRestaurant);		
	}

	@Override
	public List<Restaurant> query() {
		return restaurantDao.findAll();
				
	}

	@Override
	public Restaurant queryId(long id) {		
		return restaurantDao.findById(id);
	}
}
