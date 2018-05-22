package com.lisotti.topic3.service;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import com.lisotti.topic3.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

	@Autowired
    CartRepo cartRepo;

	public CartService(CartRepo repo) {
		this.cartRepo = repo;
	}

	public void addProduct(Product p, int id) {
		Cart c = cartRepo.getCartById(id);
		c.addProduct(p);
	}

	public boolean removeProduct(String productName, int id) {
		boolean rtn=false;
		Cart c = cartRepo.getCartById(id);
		if (c!=null){
			c.removeProduct(productName);
			rtn= true;
		}
		return rtn;

	}

	public Cart getCart(int id) {
		Cart c = null;
		c = cartRepo.getCartById(id);

		return c;
	}

	public void addCart(Cart c){
		cartRepo.addCart(c);
	}

}
