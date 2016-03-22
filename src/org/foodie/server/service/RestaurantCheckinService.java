package org.foodie.server.service;
import java.util.List;

import org.foodie.server.entity.Dish;
import org.foodie.server.entity.DishLog;
import org.foodie.server.entity.DishLogView;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantCheckinService {

	List<DishLogView> queryYesterdayLog(long restaurantId);
	
	void saveTodayLog(List<DishLog> log);
	
}