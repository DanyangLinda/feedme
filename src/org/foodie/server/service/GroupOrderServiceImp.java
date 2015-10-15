package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.dao.GroupDao;
import org.foodie.server.dao.GroupMemberDao;
import org.foodie.server.dao.GroupOrderDao;
import org.foodie.server.dao.GroupOrderedDishDao;
import org.foodie.server.entity.GroupMember;
import org.foodie.server.entity.GroupOrder;
import org.foodie.server.entity.GroupOrderedDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupOrderServiceImp implements GroupOrderService {
	@Autowired
	private GroupOrderDao gOrderDao;
	@Autowired
	private GroupMemberDao gMemberDao;
	@Autowired
	private GroupOrderedDishDao gDishDao;
	@Autowired
	private GroupDao gDao;
	
	@Override
	public long create(GroupOrder gOrder) {
		gOrder.setMembers(1);
		gOrderDao.save(gOrder);
		long userId=gOrder.getUserId();
		long groupId=gOrder.getId();
		GroupMember gm=new GroupMember();
		gm.setGroupId(groupId);
		gm.setUserId(userId);
		gm.setShareDF(gOrder.getDeliveryFee());
		gMemberDao.save(gm);
		return gm.getId();
	}

	@Override
	public void addMember(GroupMember gMember) {
		long gId=gMember.getGroupId();
		System.out.println("#### Group Id: "+gId);
		GroupOrder gOrder = gOrderDao.findOne(gId);
		double fee=gOrder.getDeliveryFee();
		System.out.println("#### Delevery Fee: "+fee);
		long members=gOrder.getMembers();
		System.out.println("#### Members: "+ members);
		double sharedFee=fee/(members+1);
		gMember.setShareDF(sharedFee);
		System.out.println("#### SharedFee: "+ sharedFee);
		gMemberDao.save(gMember);	
		int ret=gDao.updateMembers(gId);
		int ret2=gDao.updateFee(sharedFee, gId);
		System.out.println("Update  members finished: "+ret);
		System.out.println("Update credits finished: "+ret2);
	}

	@Override
	public void addDish(List<GroupOrderedDish> dishes) {
			gDishDao.save(dishes);
	}

	@Override
	public List<GroupOrder> queryGOrder(String suburb, String street, String building) {
		return gOrderDao.findGroupOrder(suburb, street, building);	
	}	
	

}
