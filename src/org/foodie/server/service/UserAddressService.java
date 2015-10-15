package org.foodie.server.service;
/**
 * @author Danyang Li
 */
import java.util.List;

import org.foodie.server.entity.UserAddress;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Danyang Li
 *
 */
@Service
public interface UserAddressService {
	void createOne(UserAddress ua);
	List<UserAddress> query(long userId);
}
