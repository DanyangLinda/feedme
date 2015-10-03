package org.foodie.server.dao;

import java.util.List;

import javax.transaction.Transactional;

//import org.foodie.server.entity.Order;
//import org.foodie.server.entity.Restaurant;
import org.foodie.server.infor.OrderInfor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Danyang
 *
 */
@Transactional
public class OrderDao {
	public List<OrderInfor> findByUser(long userId){
		String hql="select new OrderInfor(o.dishId, o.shopId, o.orderId, o.userId, o.status, r.name, d.name, d.price, o.amount) from order o, restaurant r, dish d where o.userId="+userId+" and o.shopId=r.id and o.dishId=dishId";
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		
		Session session =  sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();		
	}		
}
//@Transactional
//public interface OrderDao extends  CrudRepository<Order, Long>{
//	
//	@Query("select name from order where order.id=?1")
//	Order findById(int orderId);
//}