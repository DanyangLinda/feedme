package org.foodie.server.controller;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.GroupMember;
import org.foodie.server.entity.GroupOrder;
import org.foodie.server.entity.GroupOrderedDish;
import org.foodie.server.infor.GroupOrderInfo;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.service.GroupOrderService;
import org.foodie.server.service.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groupOrder")
public class GroupOrderController {
	@Autowired 
	GroupOrderService gOrderService;
	
	@RequestMapping("/newGroupOrder")
	@ResponseBody
	public GroupOrderInfo create(@RequestBody()GroupOrder gOrder){
		long joinId;
		try{
			joinId=gOrderService.create(gOrder);
		}catch(Exception e){
			System.out.println(e.toString());
			return new GroupOrderInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}	
		return new GroupOrderInfo(joinId,gOrder.getId());
	}
	
	@RequestMapping("/newMember")
	@ResponseBody
	public MemberInfo newMember(@RequestBody() GroupMember gMember){
		try{
			System.out.println("@@@");
			gOrderService.addMember(gMember);
		}catch(Exception e){
			System.out.println("$$$$$"+e.toString());
			return new MemberInfo(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new MemberInfo(gMember.getId(),gMember.getShareDF());
	}
	
	@RequestMapping("/orderedDish")
	@ResponseBody
	public Infor orderedDishe(@RequestBody() List<GroupOrderedDish> dishes){
		try{
			gOrderService.addDish(dishes);
		}catch(Exception e){
			System.out.println(e.toString());
			return new Infor(e.toString(),StatusCode.PERSIST_ERROR);
		}
		return new Infor();		
	}
	
	@RequestMapping("/queryGOrder")
	@ResponseBody
	public List<GroupOrder> query(@RequestParam("suburb")String suburb, @RequestParam("street")String street, @RequestParam("building")String building){
		List<GroupOrder> groupOrders=null;
		try{
			groupOrders=gOrderService.queryGOrder(suburb, street, building);
		}catch (Exception e){
			System.out.println(e.toString());
			return null;			
		}
		return groupOrders;
	}
		
}
