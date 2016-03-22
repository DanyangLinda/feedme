package org.foodie.server.service;

import java.util.List;

import org.foodie.server.dao.DishDao;
import org.foodie.server.dao.DishLogDao;
import org.foodie.server.entity.Dish;
import org.foodie.server.entity.DishLog;
import org.foodie.server.entity.DishLogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantCheckinServiceImp implements RestaurantCheckinService{
	@Autowired
	DishDao dishDao;
	
	@Autowired
	DishLogDao dishLogDao;
	
	@Override
	public List<DishLogView> queryYesterdayLog(long restaurantId) {
		return dishLogDao.getYestodayLog(restaurantId);
		//return dishLogDao.findByDatAndShopId(restaurantId);
		//return dishLogDao.findByShopId(restaurantId);
	}

	@Override
	public void saveTodayLog(List<DishLog> log) {
		dishLogDao.saveTodayLog(log);	
	}

}
