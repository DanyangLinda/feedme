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
		this.order=order;
	}
	public List<OrderedDish> getDishes() {
		return dishes;
	}
	public void setDishes(List<OrderedDish> dishes) {
		this.dishes.addAll(dishes);
	}	
}
