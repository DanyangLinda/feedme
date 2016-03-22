package org.foodie.server.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.foodie.server.entity.DishLogView;
import org.foodie.server.entity.Dish;
import org.foodie.server.entity.DishLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DishLogDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Dish> getAvailableDishes(long restaurantId){
		String hql="select a from Dish a, DishLog b where a.dishId = b.dishId and b.available = 1 and  b.dat = current_date() and b.restaurantId ="+restaurantId+" and a.shopId="+restaurantId;
		Session session = sessionFactory.getCurrentSession();
		return (List<Dish>)session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DishLogView> getYestodayLog(long restaurantId){
		String hql = "select a.id, a.shopId, a.name, a.type, a.description, a.price, a.photo, a.ingredient, a.discount, a.sold, a.flavor, b.available from Dish as a, DishLog as b where a.id = b.dishId and b.dat = SUBDATE(CURDATE(),1) and b.restaurantId="+restaurantId;
		Session session = sessionFactory.getCurrentSession();
		return (List<DishLogView>)session.createQuery(hql).list();
	}
	
	public void saveTodayLog(List<DishLog> log){
		for (DishLog o : log){
			sessionFactory.getCurrentSession().save(o);
		}
	}
	
	public void updateAvailibility(DishLog log){
		sessionFactory.getCurrentSession().update(log);
	}
	
}

/*@Component
@Transactional
public class DishLogDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<DishLogView> getAvailableDishes(long restaurantId){
		String hql="FROM DishLogView d WHERE d.dat=current_date() AND d.available=1 AND d.shopId="+restaurantId;
		Session session = sessionFactory.getCurrentSession();
		//return (List<DishLogView>)session.createQuery(hql).list();
		List<DishLogView> results = (List<DishLogView>)session.createQuery(hql).list();
		System.out.println("/n"+results.size()+"/n");
		return results;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DishLogView> getYestodayLog(long restaurantId){
		//String hql = "FROM DishLogView as d WHERE d.dat=SUBDATE(CURDATE(),1) AND d.shopId="+restaurantId;
		String hql = "FROM DishLogView";
		String sql = "select * from currentavailabledish";
		Session session = sessionFactory.getCurrentSession();
		//return (List<DishLogView>)session.createQuery(hql).list();
		DishLogView results = (DishLogView) session.createSQLQuery(sql).uniqueResult();
		System.out.println("\n ddd"+results.getDishId()+"\n");
		return null;
	}
	
	public void saveTodayLog(List<DishLog> dishLog){
		for ( DishLog d : dishLog){
			//String hql = ""
		}
	}

}*/

/*@Transactional
public interface DishLogDao extends CrudRepository<DishLogView,Long>{
	@Query("select s from DishLogView s where s.dat=SUBDATE(CURDATE(),1) and s.shopId = ?1")
    List<DishLogView> findByDatAndShopId(long restaurantId);
	
	List<DishLogView>findByShopId(long restuanrantId);
	
	
}
*/
