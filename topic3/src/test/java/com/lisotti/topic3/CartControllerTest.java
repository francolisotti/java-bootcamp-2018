package com.lisotti.topic3;

import com.lisotti.topic3.controller.CartController;
import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import com.lisotti.topic3.repos.CartRepo;
import com.lisotti.topic3.repos.UserRepo;
import com.lisotti.topic3.service.CartService;
import com.lisotti.topic3.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {

    private CartController cartController;
    private CartService cartService;
    private UserService userService;

    @Before
    public void contextLoads() {
        CartService cartService = new CartService (mock(CartRepo.class));
        UserService userService =  new UserService(mock(UserRepo.class));
        this.cartController = new CartController(cartService,userService);
    }

    @Test
    public void whenACartIsCreated(){
        Cart c = (cartController.createCart("ExampleName","ExamplePass"));

        assertEquals(c,cartService.getCart(1));
    }

    @Test
    public void whenAProductIsAdded(){
        Cart c = (cartController.createCart("ExampleName","ExamplePass"));
        Product p = mock(Product.class);
        cartController.addProduct(c.getId(),p.getName());

        assertEquals(p,cartController.viewCart(1).getAllProducts().get(0));
    }

    @Test
    public void whenAProductIsDeleted(){
        Cart c = (cartController.createCart("ExampleName","ExamplePass"));
        Product p = mock(Product.class);
        cartController.addProduct(c.getId(),p.getName());

        cartController.deleteProduct(c.getId(),p.getName());
        assertEquals(true,cartController.viewCart(1).getAllProducts().isEmpty());

    }

    @Test
    public void whenACartIsRequired(){
        Cart c = (cartController.createCart("ExampleName","ExamplePass"));

        assertEquals(c,cartController.viewCart(1));
    }
}
