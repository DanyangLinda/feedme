package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import javax.transaction.Transactional;
import org.foodie.server.entity.State;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface StateDao extends CrudRepository<State, Long>{
	State findOneByName(String name);
}
