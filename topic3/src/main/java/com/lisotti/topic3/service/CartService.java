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

	public void removeProduct(String productName, int id) {
		Cart c = cartRepo.getCartById(id);
		c.removeProduct(productName);
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
