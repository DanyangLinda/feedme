package org.foodie.server.infor;
/**
 * @author Danyang Li
 */

import java.util.List;

import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDishesView;

public class OrderInfor {
	private long restaurantId;
	private long orderId;
	private long userId;
	private String status;
	private Integer fee;
	private List<OrderedDishesView> dishes;
	
	public OrderInfor(){
		
	}
	
	public OrderInfor(Order order){
		this.restaurantId=order.getShopId();
		this.orderId=order.getOrderId();
		this.userId=order.getUserId();
		this.status=order.getStatus();
		this.fee=order.getFee();
	}
	

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public List<OrderedDishesView> getDishes() {
		return dishes;
	}

	public void setDishes(List<OrderedDishesView> dishes) {
		this.dishes.addAll(dishes);
	}	
}
