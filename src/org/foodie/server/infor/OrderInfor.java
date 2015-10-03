package org.foodie.server.infor;
/**
 * 
 * @author Danyang Li
 *
 */
public class OrderInfor {
	private long dishId;
	private long restaurantId;
	private long orderId;
	private long userId;
	private String status;
	private String restaurant;
	private String dish;
	private Integer price;
	private Integer amount;
	
	public OrderInfor(long dishId, long restaurantId, long orderId, long userId, String status, String restaurant, String dish, Integer price, Integer amount){
		this.dishId=dishId;
		this.restaurantId=restaurantId;
		this.orderId=orderId;
		this.userId=userId;
		this.status=status;
		this.restaurant=restaurant;
		this.dish=dish;
		this.price=price;
		this.amount=amount;
	}
	
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
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
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
