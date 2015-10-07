package org.foodie.server.service;
import java.util.ArrayList;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.dao.OrderDao;
import org.foodie.server.dao.OrderedDishesDao;
import org.foodie.server.dao.OrderedDishesViewDao;
import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDish;
import org.foodie.server.entity.OrderedDishesView;
import org.foodie.server.infor.Order2Dishes;
import org.foodie.server.infor.OrderInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class OrderServiceImp implements OrderService{
	@Autowired
	OrderedDishesViewDao orderedDishesViewDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderedDishesDao orderedDishesDao;
	
	@Override
	public List<OrderInfor> queryOrderByUserId(long userId) {
		List<OrderInfor> orderInfors=new ArrayList<OrderInfor>();
		List<Order> orders=orderDao.findByUserId(userId);
		for(Order o : orders){
			OrderInfor orderInfor=new OrderInfor(o);
			List<OrderedDishesView> dishes=null;
			dishes = orderedDishesViewDao.findByOrderId(o.getId());
			orderInfor.setDishes(dishes);
			orderInfors.add(orderInfor);
		}
		return orderInfors;
	}
	
	@Override
	public void saveOrder(Order2Dishes order2dishes){
		Order order = order2dishes.getOrder();
		List<OrderedDish>dishes = order2dishes.getDishes();
		orderDao.save(order);
		long orderId=order.getId();
		for(OrderedDish od:dishes){
			od.setOrderId(orderId);
		}	
		orderedDishesDao.save(dishes);
	}

}
