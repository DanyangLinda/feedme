package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;

import javax.transaction.Transactional;

import org.foodie.server.entity.Building;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface BuildingDao extends CrudRepository<Building, Long> {
	List<Building> findByStreatId(long streatId);

}
