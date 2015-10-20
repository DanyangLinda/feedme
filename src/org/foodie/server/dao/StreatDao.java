package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;

import javax.transaction.Transactional;

import org.foodie.server.entity.Street;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface StreatDao extends CrudRepository<Street, Long> {
	List<Street> findBySuburbId(long suburbId);

}
