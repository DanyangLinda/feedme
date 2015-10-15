package org.foodie.server.dao;
/**
 * @author Danyang Li
 */
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.foodie.server.entity.GroupMember;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface GroupMemberDao extends CrudRepository<GroupMember, Long> {
	/*default int countMember(long gId){
		String hql="select count(*) from GroupMember gm where gm.groupId="+gId;
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		Session session =  sessionFactory.getCurrentSession();
		return (int)session.createQuery(hql).uniqueResult();			
	}*/
}
