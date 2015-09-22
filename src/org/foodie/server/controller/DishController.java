package org.foodie.server.controller;
import java.util.List;
import org.apache.log4j.Logger;
import org.foodie.server.entity.Dish;
import org.foodie.server.infor.DishInfo;
import org.foodie.server.infor.DishListInfo;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Danyang Li
 *
 */
@RestController
@RequestMapping("/dishes")
public class DishController {
	@Autowired
	private DishService dishService;
	
	private static Logger log = Logger.getLogger(UserController.class.getName());
		
	@RequestMapping("/newdish")
	@ResponseBody
	public DishInfo create(@RequestBody()Dish newdish){		
		try{
			dishService.create(newdish);
		}catch(Exception e){
			log.error(e);
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new DishInfo(newdish.getId());
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public DishInfo remove(@RequestParam("dishId")long dishId){
		Dish removedDish = new Dish(dishId);
		try{
			dishService.remove(removedDish);
		}catch(Exception e){
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
	System.out.println("############ "+dishId);
		return new DishInfo(dishId);		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public DishInfo update(@RequestBody()Dish updatedDish){
		try{
			dishService.update(updatedDish);
		}catch(Exception e){
			log.error(e);
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new DishInfo(updatedDish.getId(),updatedDish.getType());
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public DishListInfo query(@RequestParam("shopId")long shopid){
		List<Dish> dishes =null;
		try{
			dishes = dishService.query(shopid);
		}catch(Exception e){
			return new DishListInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		if(dishes!=null&&dishes.size()!=0){
			return new DishListInfo(dishes);
		}else{
			return null;
		}
	}
	

}
