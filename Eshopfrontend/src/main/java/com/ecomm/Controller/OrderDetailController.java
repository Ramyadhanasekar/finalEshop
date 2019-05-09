package com.ecomm.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.DAO.CartItemDAO;
import com.ecomm.DAO.OrderDetailDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.OrderDetail;

@Controller
public class OrderDetailController {
	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Autowired
	CartItemDAO cartDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value="/confirmorder")
	public String ConfirmOrderDetail(HttpSession session,Model m)
	{ 
		String username=(String)session.getAttribute("username");
		List<CartItem> listCarts=cartDAO.getCartItems(username);
		m.addAttribute("listCarts",listCarts);
		m.addAttribute("grandtotal",grandTotal(listCarts));
		return "Order";
	}

	@RequestMapping(value="/paymentconfirm")
	public String PaymentConfirm(HttpSession session,@RequestParam("payment")String payment,@RequestParam("ShippingAddress")String ShippingAddress,Model m) 
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCarts=cartDAO.getCartItems(username);
		for(CartItem cart1:listCarts)
		{
				CartItem cart2=cartDAO.getCartItem(cart1.getCartId());
				cart2.setPaymentStatus("P");
				cartDAO.updateCartItem(cart2);
		}
		
		List<CartItem> listPaidCarts=cartDAO.getPaidCarts(username);
		m.addAttribute("listPaidCarts",listPaidCarts);
		m.addAttribute("grandtotal",grandTotal(listPaidCarts));
		
		OrderDetail orderdetail=new OrderDetail();
		orderdetail.setUsername(username);
		orderdetail.setOrderDate(String.format("%tc",new Date()));
		orderdetail.setTotalAmount(grandTotal(listPaidCarts));
		orderdetail.setTransactionType(payment);
		orderdetail.setShippingAddr(ShippingAddress);
		orderDetailDAO.confirmOrder(orderdetail);
		
		
		List<OrderDetail> listOrderDetail=orderDetailDAO.getOrderDetail(username);
		
		int id=0;
		for(OrderDetail orderdetail1:listOrderDetail)
		{
				if(orderdetail.getOrderId()>id) {
					id=orderdetail.getOrderId();
				}
		}
		
		m.addAttribute("listOrderDetail",listOrderDetail);
		
		OrderDetail orderdetail2=orderDetailDAO.getOrderId(id); 
		m.addAttribute("orderdetail",orderdetail2);
		
		return "ThankYou";
	}


	public double grandTotal(List<CartItem> listCarts)
	{

		double grandTotal1=0,grandTotal=0;
		try {
		for(CartItem cart: listCarts)
		{
			grandTotal1=grandTotal1+cart.getQuantity()*(productDAO.getProduct(cart.getProductId()).getPrice());
			
		}
		int grandTotal2=(int)(grandTotal1*100);
		grandTotal=(double)grandTotal2/100; 
		}
		catch(Exception e) {
			System.out.println("total error");
		}
		
		return grandTotal;
	}

	public double grandTotals(List<CartItem> listPaidCarts)
	{

		double grandTotal1=0,grandTotal=0;
		try {
		for(CartItem cart: listPaidCarts)
		{
			grandTotal1=grandTotal1+cart.getQuantity()*(productDAO.getProduct(cart.getProductId()).getPrice());
			
		}
		int grandTotal2=(int)(grandTotal1*100);
		grandTotal=(double)grandTotal2/100; 
		}
		catch(Exception e) {
			System.out.println("total error");
		}
		
		return grandTotal;
	}

	
	
}
