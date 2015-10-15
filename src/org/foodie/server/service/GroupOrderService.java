package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.GroupMember;
import org.foodie.server.entity.GroupOrder;
import org.foodie.server.entity.GroupOrderedDish;
import org.foodie.server.infor.GroupOrderInfo;

public interface GroupOrderService {
	long create (GroupOrder gOrder);
	void addMember(GroupMember gMember);
	void addDish(List<GroupOrderedDish> dishes);
	List<GroupOrder> queryGOrder(String suburb, String street, String building);

}
