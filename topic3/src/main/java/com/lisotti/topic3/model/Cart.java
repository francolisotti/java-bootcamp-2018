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

	public void setId(int id) {
		this.id = id;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		product.setId(products.size());
	}

	public Product getProductById(int id) {
		Product result = null;

		for (Product p: products){
			if (p.getId()==id){
				result=p;
			}
		}

		return result;
	}


	public void removeProductById(int id) {
		for (Product p: products){
			if (p.getId()==id){
				products.remove(p);
			}
		}
	}

	public List<Product> getAllProducts() {
		return this.products;
	}

}
