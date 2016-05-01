package org.foodie.server.controller;
// to be deleted after testing.
import java.util.List;

import org.foodie.server.entity.DishLog;
import org.foodie.server.entity.DishLogView;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.RestaurantCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/restaurant")
public class CheckinController {
	@Autowired
	private RestaurantCheckinService restaurantCheckinService;
	
	@RequestMapping("checkin")
	@ResponseBody
	public List<DishLogView> queryMenu(@RequestParam("restaurantId")long restaurantId){
		List<DishLogView> dishes=null;
		try{
			dishes=restaurantCheckinService.queryYesterdayLog(restaurantId);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return dishes;
	}
	
	@RequestMapping("refreshMenu")
	@ResponseBody
	public Infor refreshMenu(@RequestBody() List<DishLog> dishlog){
		try{
			restaurantCheckinService.saveTodayLog(dishlog);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();
	}
		
}
