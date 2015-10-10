package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;
import javax.transaction.Transactional;
import org.foodie.server.entity.Order;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface OrderDao extends CrudRepository<Order, Long> {
	Order findOneById(long orderId);
	List<Order> findByUserId(long userId);
}
