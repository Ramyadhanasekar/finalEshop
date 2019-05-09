package com.ecomm.DAO;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
    SessionFactory sessionFactory;
	public boolean addUser(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

    @Transactional
	
	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}

    }
	

    @Transactional
	
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	
	public User getUser(int userId) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,userId);
		session.close();
		return user;
	}

	
	public List<User> getUser() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=(List<User>)query.list();
		return listUser;

		
	}
	
		
	
		@Transactional
	public User get(String username)
	{
		String hql = "from User where username= "+" '" +username+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	@Transactional
	public boolean isValidUser(String username, String password) {
		System.out.println("dao impl");
		String hql ="from User where username= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if(list != null && !list.isEmpty())
		{
		
			return true;
		}
		return false;

	}
	
	
	@Transactional
	public boolean save(User user)
	{
	try {
		 Session session = sessionFactory.getCurrentSession();
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
         session.flush();
		
		return true;

	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}

   }	

}
