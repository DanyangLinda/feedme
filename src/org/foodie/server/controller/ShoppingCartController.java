package org.foodie.server.controller;
/**
 * @author Danyang Li
 */
import org.foodie.server.entity.ShoppingCart;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService cartService;
	
	@RequestMapping("/saveCart")
	@ResponseBody
	public Infor saveCart(@RequestBody()ShoppingCart cart){
		try{
			cartService.saveCart(cart);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();
	}
	
	@RequestMapping("/queryCart")
	@ResponseBody
	public ShoppingCart queryCart(@RequestParam("userId")long userId){
		ShoppingCart cart=null;
		try{
			cart=cartService.queryCart(userId);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		return cart;
	}
	
}
