package org.foodie.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.foodie.server.entity.Restaurant;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.RestaurantListInfo;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.RestaurantService;
import org.foodie.server.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("/newrestaurant")
	@ResponseBody
	public String create(){
		//test data
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setName("Name1");
		//
		try{
			restaurantService.create(newRestaurant);			
		}catch(Exception ex){
			return "exception";			
		}
		return "success!"+newRestaurant.getId();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		//test data
		long id = 1;
		Restaurant restaurant = new Restaurant(id);
		//
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
		System.out.println("*****************Step1: Eenter Update");	
		if(apkFile!=null){
			System.out.println("*****************Step2: Enter upload!");
				try{
					String path="data/upload/logo";
					String logo = uploadService.uploadImg(apkFile, path);
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
