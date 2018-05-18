package com.lisotti.topic3.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private int id;
	private List<Product> products;


	public Cart(int id) {
		this.id = id;
		this.products = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		product.setId(this.products.size());
	}

	public synchronized void removeProduct(String productName) {

		for (Product p: this.products){
			if (p.getName().equals(productName)){
				this.products.remove(p);
			}
		}
	}

	public List<Product> getAllProducts() {
		return this.products;
	}

}
