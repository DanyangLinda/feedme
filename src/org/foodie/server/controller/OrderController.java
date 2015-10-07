package org.foodie.server.controller;
/**
 * 
 * @author Danyang Li
 *
 */

import java.util.List;

import org.foodie.server.infor.Infor;
import org.foodie.server.infor.Order2Dishes;
import org.foodie.server.infor.OrderInfor;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/queryByUser")
	@ResponseBody
	public List<OrderInfor> queryByUser(@RequestParam("userId")long userId){
		List<OrderInfor> orderInfors=null;
		try{
			orderInfors=orderService.queryOrderByUserId(userId);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return orderInfors;		
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Infor createOrder(@RequestBody()Order2Dishes order2Dishes){
		try{
			orderService.saveOrder(order2Dishes);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();
	}

}
