
package com.ecomm.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.DAO.CartItemDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.Product;
@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartItemDAO cartItemDAO;

	@RequestMapping(value="/Cart")
	public String displaycart(HttpSession session,Model m) {
		String username=(String)session.getAttribute("username");
		List<CartItem> listCarts=cartItemDAO.getCartItems(username);
		m.addAttribute("listCarts", listCarts);
		m.addAttribute("grandtotal",grandTotal(listCarts));
		return "Cart";
	}

	@RequestMapping(value = "/addCart/{productId}",method = RequestMethod.POST)
	public String addCart(@PathVariable("productId") int productId,HttpSession session,Model m) {
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product",product);
		
		boolean id=false;
		String username=(String)session.getAttribute("username");
		System.out.println("username:"+username);
      //  if(username==null) {
        //	return "login";
       // }
		List<CartItem> listCarts=cartItemDAO.getCartItems(username);
		for(CartItem cart1: listCarts) {
			if(productId==cart1.getProductId()) {
				id=true;
				break;
			}
		}
		
		if(id==false) {
	
	    CartItem cart=new CartItem();
		cart.setProductId(productId);
		cart.setQuantity(1);
		cart.setUsername(username);
		cart.setProductName(product.getProductName());
		cart.setPaymentStatus("NP");
		cart.setSubtotal(product.getPrice());
		cartItemDAO.addCartItem(cart);
		m.addAttribute("listCarts", listCarts);
		m.addAttribute("grandtotal",grandTotal(listCarts));
		return "Cart";
		}
		else {
			m.addAttribute("alert","This product is already added to cart");
		}
		
		return "ProdDesc";
	}
	

	@RequestMapping(value="/deleteCart/{cartId}")
	public String deletecart(@PathVariable("cartId") int cartid,HttpSession session,Model m) 
	{
		String username=(String)session.getAttribute("username");
	CartItem cart=cartItemDAO.getCartItem(cartid);
	
    cartItemDAO.deleteCartItem(cart);
    List<CartItem> listCarts=cartItemDAO.getCartItems(username);
	m.addAttribute("listCarts", listCarts);
	m.addAttribute("grandtotal",grandTotal(listCarts));
		return "Cart";
	}
	
	@RequestMapping(value="/updateCart/{cartId}")
	public String updatecart(@PathVariable("cartId") int cartId,@RequestParam("quantity") int quantity,HttpSession session,Model m) {
		String username=(String)session.getAttribute("username");
	CartItem cart=cartItemDAO.getCartItem(cartId);
	Product product=productDAO.getProduct(cart.getProductId());
	if(quantity>5) {
		quantity=5;
		m.addAttribute("Cart",cart);
		m.addAttribute("alert","quantity can't be more than 5");
	}
	cart.setQuantity(quantity);
	int quant=(int)((quantity*product.getPrice())*100);
	double qua=(double)quant/100;
	cart.setSubtotal(qua);
    cartItemDAO.updateCartItem(cart);
    List<CartItem> listCarts=cartItemDAO.getCartItems(username);
	m.addAttribute("listCarts", listCarts);
	m.addAttribute("grandtotal",grandTotal(listCarts));
	
		return "Cart";
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
	}

	

