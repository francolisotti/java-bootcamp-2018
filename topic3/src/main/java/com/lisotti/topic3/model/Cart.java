package com.lisotti.topic3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private List<Product> products;


	public Cart(int sessionId) {
		this.id = sessionId;
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
