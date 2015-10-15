package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import javax.transaction.Transactional;
import org.foodie.server.entity.GroupOrderedDish;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface GroupOrderedDishDao extends CrudRepository<GroupOrderedDish,Long>{

}
