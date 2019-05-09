package com.ecomm.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.CartItemDAO;
import com.ecomm.model.CartItem;

public class CartTest {
	static CartItemDAO cartDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		cartDAO=(CartItemDAO)context.getBean("cartItemDAO");
}
	
	@Test
	public void addcarttest() {
		CartItem cartItem=new CartItem();
		cartItem.setProductId(2);
		cartItem.setCartId(2);
		cartItem.setQuantity(6);
		cartItem.setProductName("chocolate");
		cartItem.setUsername("ramya");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(100);
		assertTrue("Problem in Cart Insertion",cartDAO.addCartItem(cartItem));

	}
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Category",cartDAO.getCartItem(2));
	}
	@Ignore
	@Test
	public void deleteCartTest()
	{
		CartItem cart=cartDAO.getCartItem(110);
		assertTrue("Problem in Deletion:",cartDAO.deleteCartItem(cart));
	}
	
	@Test
	public void updateCartTest()
	{
		CartItem cart=cartDAO.getCartItem(197);
		cart.setQuantity(6);
		assertTrue("Problem in Updation",cartDAO.updateCartItem(cart));
	}
	
	@Test
	public void listCartTest()
	{
		List<CartItem> listCarts=cartDAO.getCartItems("ramya");
		assertNotNull("No Cart",listCarts);
		
		for(CartItem cartItem:listCarts)
		{
			System.out.print(cartItem.getCartId()+" ");
			System.out.print(cartItem.getProductId()+" ");
			System.out.println(cartItem.getProductName());
		}
	}


}
