package org.foodie.server.controller;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.UserAddress;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
	@Autowired
	private UserAddressService uaService;
	@RequestMapping("/newUserAddress")
	@ResponseBody
	public Infor create(@RequestBody()UserAddress ua){
		try{
			uaService.createOne(ua);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();
	}
	
	@RequestMapping("/queryUserAddress")
	@ResponseBody
	public List<UserAddress> query(@RequestParam("userId")long userId){
		List<UserAddress> uas=null;
		try{
			uas=uaService.query(userId);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		return uas;
	}
}
