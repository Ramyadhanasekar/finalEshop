package com.ecomm.Test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.OrderDetailDAO;
import com.ecomm.model.OrderDetail;

public class OrderTest {
	static OrderDetailDAO orderDetailDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
	}
	@Test
	public void confirmOrderDetail() {
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrderId(1);
			orderDetail.setUsername("varalakshmi");
			orderDetail.setTotalAmount(10000);
			orderDetail.setShippingAddr("chennai");
			orderDetail.setTransactionType("CC");
			orderDetail.setOrderDate(String.format("%tc",new Date()));
			assertTrue("problem in adding",orderDetailDAO.confirmOrder(orderDetail));
	}
	
	

}
