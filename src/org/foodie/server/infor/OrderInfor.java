package org.foodie.server.infor;
/**
 * @author Danyang Li
 */

import java.util.Date;
import java.util.List;

import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDishesView;

public class OrderInfor {
	private long restaurantId;
	private long orderId;
	private long userId;
	private long deliverId;
	private String state;
	private String paymentStatus;
	private Integer deliveryFee;
	private Integer totalPrice;
	private Date creatTime;
	private Date deliverTime;
	private Date finishTime;
	private List<OrderedDishesView> dishes;
	
	public OrderInfor(){
		
	}
	
	public OrderInfor(Order order){
		this.restaurantId=order.getRestaurantId();
		this.orderId=order.getId();
		this.userId=order.getUserId();
		this.deliverId=order.getDeliverId();
		this.state=order.getState();
		this.deliveryFee=order.getDeliveryfee();
		this.totalPrice=order.getTotalPrice();
		this.paymentStatus=order.getPaymentStatus();
		this.creatTime=order.getCreatTime();
		this.deliverTime=order.getDeliverTime();
		this.finishTime=order.getFinishTime();
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

	public long getDeliverId() {
		return deliverId;
	}

	public void setDeliverId(long deliverId) {
		this.deliverId = deliverId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Integer deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public List<OrderedDishesView> getDishes() {
		return dishes;
	}

	public void setDishes(List<OrderedDishesView> dishes) {
		this.dishes = dishes;
	}
	
}
