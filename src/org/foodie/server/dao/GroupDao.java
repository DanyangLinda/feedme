package org.foodie.server.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class GroupDao {	
	@Autowired
	private SessionFactory sessionFactory;
	public long countMember(long gId){
		String hql="select count(*) from GroupMember gm where gm.groupId="+gId;
		Session session =  sessionFactory.getCurrentSession();
		return (long)session.createQuery(hql).list().get(0);		
		//return (Integer)session.createQuery(hql).uniqueResult();		
	}
	
	public int updateMembers(long gId){
		String hql="update GroupOrder gOrder set gOrder.members=gOrder.members+1 where gOrder.id="+gId;
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		int ret=query.executeUpdate();
		return ret;
	}
	
	public int updateFee(final Double sharedFee, final long gId){
		String hql="update GroupMember gMember set gMember.returnedCredit=gMember.shareDF-"+sharedFee+" where gMember. groupId="+gId;	
		Session session =  sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);	
		//This operation is called bulk delete/update in Hibernate3, which improved the flexibility and efficiency of multiple update/delete.
		// But cache synchronization is not  guaranteed in this operation.
		int ret=query.executeUpdate();       
		return ret;
	}

}
