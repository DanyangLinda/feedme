package org.foodie.server.infor;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDish;

public class Order2Dishes {
	private Order order;
	private List<OrderedDish> dishes;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderedDish> getDishes() {
		return dishes;
	}
	public void setDishes(List<OrderedDish> dishes) {
		this.dishes = dishes;
	}	
}
