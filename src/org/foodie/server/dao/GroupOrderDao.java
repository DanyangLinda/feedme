package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;
import javax.transaction.Transactional;
import org.foodie.server.entity.GroupOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface GroupOrderDao extends CrudRepository<GroupOrder, Long>{
	@Query("select gOrder from GroupOrder gOrder where gOrder.suburb=?1 and gOrder.street=?2 and gOrder.building=?3")
	List<GroupOrder> findGroupOrder(String suburb,String street, String building);
}
