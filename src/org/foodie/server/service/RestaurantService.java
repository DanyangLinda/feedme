package org.foodie.server.service;

import java.util.List;

import org.foodie.server.entity.Restaurant;
import org.springframework.stereotype.Service;

/**
 * @author Danyang Li
 */
@Service
public interface RestaurantService {
	public void create(Restaurant newRestaurant);
	public void remove(Restaurant removedRestaurant);
	public void update(Restaurant updatedRestaurant);
	public List<Restaurant> query();
	public Restaurant queryId(long id);
}





