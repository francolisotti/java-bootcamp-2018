package com.lisotti.topic3.repos;


import com.lisotti.topic3.model.Cart;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepo {

	private List<Cart> mylist;

	public CartRepo(){
		this.mylist = new ArrayList<>();
	}

	public List<Cart> getAll() {

		return mylist;
	}

	public Cart getCartById(int id) {
		return mylist.get(id-1);
	}

	public void addCart(Cart c) {
		mylist.add(c);
	}

	public void removeCartById(int id) {


		mylist.remove(id-1);

	}
}
