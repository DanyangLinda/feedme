package org.foodie.server.infor;

import java.util.List;

import org.foodie.server.entity.Dish;

public class DishListInfo extends Infor{
	
	private static final long serialVersionUID = 1L;
	
	private List<Dish> dishes;
	
	public DishListInfo(){
		
	}
	
	public DishListInfo(final String statusInfo, final Integer statusCode){
		super(statusInfo,statusCode);
	}
	
	public DishListInfo(final List<Dish> dishes){
		this.dishes=dishes;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

}
