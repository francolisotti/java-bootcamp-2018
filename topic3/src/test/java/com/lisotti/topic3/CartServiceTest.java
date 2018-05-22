package com.lisotti.topic3;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import com.lisotti.topic3.repos.CartRepo;
import com.lisotti.topic3.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest {

    CartService cartService;

    @Before
    public void contextLoads() {
       CartRepo cartRepo = mock(CartRepo.class);
       cartService = new CartService(cartRepo);
    }

    @Test
    public void whenAProductIsAdded(){
        Cart c = mock(Cart.class);
        cartService.addCart(c);
        Product p = mock(Product.class);
        cartService.addProduct(p,c.getId());

        assertEquals(p,cartService.getCart(c.getId()).getAllProducts().get(0));

    }

    @Test
    public void whenAProductIsRemoved(){
        Cart c = mock(Cart.class);
        cartService.addCart(c);
        Product p = mock(Product.class);
        cartService.addProduct(p,c.getId());

        boolean result = cartService.removeProduct(p.getName(),c.getId());
        assertEquals(true,result);
    }

    @Test
    public void whenACartIsRequired(){

    }


}
