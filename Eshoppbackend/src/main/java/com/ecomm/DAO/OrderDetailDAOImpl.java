package com.ecomm.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean confirmOrder(OrderDetail orderDetail) {
		
		
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
			}

	@Override
	public List<OrderDetail> getOrderDetail(String username) {
		
		 Session session=sessionFactory.openSession();
			Query query = session.createQuery("from OrderDetail where username=:username");
			query.setParameter("username",username);
			List<OrderDetail> listOrderDetail=(List<OrderDetail>)query.list();
			return listOrderDetail;	}

	@Override
	public OrderDetail getOrderId(int OrderId) {
		Session session=sessionFactory.openSession();
	 	OrderDetail orderDetail=(OrderDetail)session.get(OrderDetail.class,OrderId);
	 	session.close();
	 	return orderDetail;	}

}
