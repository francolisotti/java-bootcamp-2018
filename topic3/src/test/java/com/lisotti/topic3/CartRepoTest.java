package com.lisotti.topic3;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.repos.CartRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepoTest {

    CartRepo cartRepo;

    @Before
    public void contextLoads() {
        cartRepo = new CartRepo();
    }

    @Test
    public void whenTheRepoListIsRequired(){
        Cart c = mock(Cart.class);
        cartRepo.addCart(c);
        assertEquals(c,cartRepo.getAll().get(0));
    }

    @Test
    public void whenACartIsRequired(){
        Cart c = mock(Cart.class);
        cartRepo.addCart(c);
        assertEquals(c,cartRepo.getCartById(1));
    }

    @Test
    public void whenACartIsRemoved(){
        Cart c = mock(Cart.class);
        cartRepo.addCart(c);
        cartRepo.removeCartById(1);
        assertEquals(true,cartRepo.getAll().isEmpty());
    }
}
