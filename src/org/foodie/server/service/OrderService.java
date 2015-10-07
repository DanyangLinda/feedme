package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.entity.Order;
import org.foodie.server.entity.OrderedDish;
import org.foodie.server.infor.Order2Dishes;
import org.foodie.server.infor.OrderInfor;
import org.springframework.stereotype.Service;
@Service
public interface OrderService {
	List<OrderInfor> queryOrderByUserId(long userId);
	void saveOrder(Order2Dishes order2dishes);
	
}
