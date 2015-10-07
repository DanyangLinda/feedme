package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;
import javax.transaction.Transactional;
import org.foodie.server.entity.OrderedDishesView;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface OrderedDishesViewDao extends CrudRepository<OrderedDishesView, Long> {
	List<OrderedDishesView> findByOrderId(long orderId);
}
