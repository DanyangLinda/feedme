package org.foodie.server.controller;

import java.io.IOException;
import java.util.List;

import org.foodie.server.entity.DishLog;
import org.foodie.server.entity.DishLogView;
import org.foodie.server.entity.Restaurant;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.RestaurantInfo;
import org.foodie.server.infor.RestaurantListInfo;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.RestaurantService;
import org.foodie.server.service.ImgService;
import org.foodie.server.service.RestaurantCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Danyang Li
 *
 */
@RestController
@CrossOrigin()
@RequestMapping("/restaurants")
public class RestaurantController {	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ImgService imgService;
	@Autowired
	private RestaurantCheckinService restaurantCheckinService;
	
	@RequestMapping("/checkin")
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
	
	@RequestMapping("/refreshMenu")
	@ResponseBody
	public Infor refreshMenu(@RequestBody() List<DishLog> dishlog){
		DishLog first = dishlog.get(0);
		System.out.println("DishLog\n"+first.getDish_id()+"\t"+first.getRestaurant_id()+"\t"+first.getDat());
		
		try{
			restaurantCheckinService.saveTodayLog(dishlog);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Restaurant getRestaurant(@RequestParam("email")String email, @RequestParam("pwd")String pwd){
		try{
			  final Restaurant restaurant=restaurantService.queryByEmail(email.trim());
			  if(restaurant!=null&&restaurant.getPassword().equals(pwd)){
				  return restaurant;
			  }
		  }catch(Exception e){
			  System.out.println(e.toString());
		  }	
		return null;
	}
	
	@RequestMapping("/newrestaurant")
	@ResponseBody
	public RestaurantInfo create(@RequestParam(value="logoFile",required=false) MultipartFile logoFile, Restaurant restaurant){
		if(logoFile!=null){
			try {
				String path="data/logo";
				String logo = imgService.uploadImg(logoFile, path);
				restaurant.setLogo(logo);
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		try{
			restaurantService.create(restaurant);			
		}catch(Exception e){
			return new RestaurantInfo(e.toString(),StatusCode.PERSIST_ERROR);			
		}
		return new RestaurantInfo(restaurant.getId());
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		//test data
		long id = 1;
		Restaurant restaurant = new Restaurant(id);
		try{
			restaurantService.remove(restaurant);
		}catch(Exception e){
			return "error";
		}		
		return "success!";		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Infor update(@RequestParam(value="apkFile",required=false) MultipartFile apkFile, Restaurant restaurant){	
		System.out.println("**********");
		if(apkFile!=null){
				try{
					String path="data/logo";
					String logo = imgService.uploadImg(apkFile, path);
					String oldImgpath=path+"/"+restaurantService.queryId(restaurant.getId()).getLogo();
					imgService.deleteImg(oldImgpath);
					restaurant.setLogo(logo);
				}catch(Exception e){
					System.out.println(e.toString());
				}
			}
			try{
				restaurantService.update(restaurant);
			}catch(Exception e){
				return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
			}
		return new Infor();		
	}
	
	@RequestMapping("/restaurantList")
	@ResponseBody
	public RestaurantListInfo getAll(){
		List<Restaurant> restaurants = null;
		try{
			restaurants=restaurantService.query();
		}catch(Exception e){
			return new RestaurantListInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		if(restaurants!=null&&restaurants.size()!=0){
			return new RestaurantListInfo(restaurants);
		}
		return null;
	}
	
	@RequestMapping("/allRestaurant")
	@ResponseBody
	public List<Restaurant> findall(){
		List<Restaurant> restaurants;
		try{
			restaurants=restaurantService.query();
		}catch(Exception e){
			return null;
		}
		return restaurants;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Restaurant query(@RequestParam("id")long id){
		return restaurantService.queryId(id);
	}
}
