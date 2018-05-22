package com.lisotti.topic3;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {

	private Cart cart;
	@Before
	public void contextLoads() {
		this.cart = new Cart(1);
	}

	@Test
	public void whenProductIsAdded(){
		Product p = mock(Product.class);
		this.cart.addProduct(p);
		assertEquals(p,cart.getAllProducts().get(0));
	}

	@Test
	public void whenProductIsRemoved(){
		Product p = mock(Product.class);
		this.cart.addProduct(p);
		p.setName("Test");

		assertEquals(true,this.cart.removeProduct(p.getName()));
	}


}
