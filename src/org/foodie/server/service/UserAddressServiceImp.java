package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.dao.UserAddressDao;
import org.foodie.server.entity.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserAddressServiceImp implements UserAddressService {
	@Autowired
	private UserAddressDao uaDao;

	@Override
	public void createOne(UserAddress ua) {
		uaDao.save(ua);	
	}

	@Override
	public List<UserAddress> query(long userId) {
		return uaDao.findByUserId(userId);
	}

}
