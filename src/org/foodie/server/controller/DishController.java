package org.foodie.server.controller;
import java.util.List;
import org.apache.log4j.Logger;
import org.foodie.server.entity.Dish;
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
	public Dish create(@RequestBody()Dish newdish){		
		try{
			dishService.create(newdish);
		}catch(Exception e){
			log.error(e);
			return null;
		}
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String remove(@RequestParam("dish")Dish removedDish){
		try{
			dishService.remove(removedDish);
		}catch(Exception e){
			log.error(e);
			return"error!";
		}
		return("success!");		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestParam("dish")Dish updatedDish){
		try{
			dishService.update(updatedDish);
		}catch(Exception e){
			log.error(e);
		}
		return("success!");
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Dish> query(@RequestParam("shopId")long shopid){
		List<Dish> dishes =null;
		try{
			dishes = dishService.query(shopid);
		}catch(Exception e){
			log.error(e);
			return null;
		}
		return dishes;
	}
	

}
