package com.ecomm.DAO;

import java.util.List;

import com.ecomm.model.CartItem;

public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getCartItems(String username);
	public List<CartItem> getPaidCarts(String username);

}
