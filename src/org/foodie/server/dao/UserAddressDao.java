package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;
import org.foodie.server.entity.UserAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressDao extends CrudRepository<UserAddress, Long> {
	List<UserAddress> findByUserId(long userId);
}
