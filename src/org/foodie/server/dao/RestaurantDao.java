package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import java.util.List;

import javax.transaction.Transactional;

import org.foodie.server.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface RestaurantDao extends CrudRepository<Restaurant, Long> {

  /**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param email the user email.
   */
  public List<Restaurant> findAll();

  public Restaurant findById(long id);
   

} // class UserDao
  