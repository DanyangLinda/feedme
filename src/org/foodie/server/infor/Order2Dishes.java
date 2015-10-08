package org.foodie.server.infor;
import java.util.ArrayList;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDish;

public class Order2Dishes {
	private Order order;
	private List<OrderedDish> dishes=new ArrayList<OrderedDish>();
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		/*this.order.setUserId(order.getUserId());
		this.order.setRestaurantId(order.getRestaurantId());
		this.order.setDeliveryfee(order.getDeliveryfee());
		this.order.setTotalPrice(order.getTotalPrice());
		this.order.setCreatTime(order.getCreatTime());
		this.order.setDeliverTime(order.getDeliverTime());
		this.order.setFinishTime(order.getFinishTime());
		this.order.setPaymentStatus(order.getPaymentStatus());
		this.order.setState(order.getState());*/
		this.order=order;
	}
	public List<OrderedDish> getDishes() {
		return dishes;
	}
	public void setDishes(List<OrderedDish> dishes) {
		this.dishes.addAll(dishes);
	}	
}
