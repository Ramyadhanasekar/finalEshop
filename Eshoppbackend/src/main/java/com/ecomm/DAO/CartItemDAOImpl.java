package com.ecomm.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.CartItem;


@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

			@Autowired
		SessionFactory sessionFactory;
		
		
		@Override
		
		public boolean addCartItem(CartItem cartItem)
		{
			try
			{
			sessionFactory.getCurrentSession().save(cartItem);
		    System.out.println("Cart added");
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised:"+e);
			return false;
			}
		}
		@Override
		public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			System.out.println("Cart Updated");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
			
		}

		@Override
		public boolean deleteCartItem(CartItem cartItem) 
		{
			try
			{
				sessionFactory.getCurrentSession().delete(cartItem);
				System.out.println("Cart Deleted");
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}			
		
		
		}

		@Override
		public List<CartItem> getCartItems(String username) 
		{
			Session session=sessionFactory.openSession();
			Query query= session.createQuery("from CartItem where username=:username and paymentstatus='NP'");
				query.setParameter("username",username);
				List<CartItem> listCart=(List<CartItem>)query.list();
				System.out.println("....list...");
				return listCart;
			
	}
		
		


	@Override
	public CartItem getCartItem(int cartId) 
		
				{
				Session session=sessionFactory.openSession();
				CartItem cartItem=(CartItem)session.get(CartItem.class,cartId);
				session.close();
				return cartItem;
				}
	@Override
	public List<CartItem> getPaidCarts(String username) {
		
		Session session=sessionFactory.openSession();
		Query query= session.createQuery("from CartItem where username=:username and paymentstatus='P'");
			query.setParameter("username",username);
			List<CartItem> listCart=(List<CartItem>)query.list();
			System.out.println("....list...");
			return listCart;
		
		
		
		
			
	}
				
				
				
		

		}

