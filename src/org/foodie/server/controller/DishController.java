package org.foodie.server.controller;
import java.util.List;
import org.apache.log4j.Logger;
import org.foodie.server.entity.Dish;
import org.foodie.server.infor.DishInfo;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.DishService;
import org.foodie.server.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/dishes")
public class DishController {
	@Autowired
	private DishService dishService;
	@Autowired
	private ImgService imgService;
	
	private static Logger log = Logger.getLogger(UserController.class.getName());		
	
	@RequestMapping("/newdish")
	@ResponseBody
	public DishInfo create(@RequestParam(value="phFile", required=false)MultipartFile phFile, Dish dish){
		if(phFile!=null){
			try{
				String path="data/photo";
				String photo=imgService.uploadImg(phFile, path);
				dish.setPhoto(photo);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		try{
			dishService.create(dish);
		}catch(Exception e){
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new DishInfo(dish.getId(),dish.getPhoto());
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public DishInfo remove(@RequestParam("dishId")long dishId){
		Dish removedDish = dishService.queryOne(dishId);
		try{
			dishService.remove(removedDish);
		}catch(Exception e){
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		System.out.println("!!!!!!!!!!!!!! delete photo: "+removedDish.getPhoto());
		String imgPath="data/photo/"+removedDish.getPhoto();
		imgService.deleteImg(imgPath);
		return new DishInfo(dishId);		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public DishInfo update(@RequestParam(value="pho",required=false)MultipartFile phFile,Dish updatedDish){
		if(phFile!=null){
			try{
				String path="data/photo";
				String photo=imgService.uploadImg(phFile, path);
				String oldImgpath="data/photo/"+dishService.queryOne(updatedDish.getId()).getPhoto();
				imgService.deleteImg(oldImgpath);
				updatedDish.setPhoto(photo);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		try{
			dishService.update(updatedDish);
		}catch(Exception e){
			log.error(e);
			return new DishInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		DishInfo dishInfo=new DishInfo(updatedDish);
		return dishInfo;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Dish> query(@RequestParam("shopId")long shopid){
		List<Dish> dishes =null;
		try{
			dishes = dishService.query(shopid);
		}catch(Exception e){
//			return new DishListInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		if(dishes!=null&&dishes.size()!=0){
			return  dishes;
		}else{
			return null;
		}
	}
}
