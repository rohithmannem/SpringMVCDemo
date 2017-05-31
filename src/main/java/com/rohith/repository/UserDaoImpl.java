package com.rohith.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rohith.entities.UserEntity;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertUser(UserEntity userEntity) {

		Session session = getSessionFactory().getCurrentSession();

		session.beginTransaction();

		session.save(userEntity);

		session.getTransaction().commit();
	}

	

	@Override
	public UserEntity getUser(String username) {
		Session session = getSessionFactory().getCurrentSession();

		session.beginTransaction();
        
		String hql = "select * from Users1 where username =:username";
		
		Query query = session.createSQLQuery(hql).addEntity(UserEntity.class);
		
		query.setParameter("username", username);
		
		/*Criteria criteria = session.createCriteria(UserEntity.class);
		
		criteria.add(Restrictions.eq("username", username));
		*/
		@SuppressWarnings("unchecked")
		List<UserEntity> listUserEntity = (List<UserEntity>)query.list();
		
		if(listUserEntity != null &&  !listUserEntity.isEmpty()){
			
			return listUserEntity.get(0);
		}
		return null;
		
		
	}

	@Override
	public List<UserEntity> listUsers() {

		Session session = getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Criteria criteria = session.createCriteria(UserEntity.class);

		@SuppressWarnings("unchecked")
		List<UserEntity> users = criteria.list();

		return users;

	}

}
