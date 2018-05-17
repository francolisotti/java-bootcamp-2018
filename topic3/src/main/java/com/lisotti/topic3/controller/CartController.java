package com.lisotti.topic3.controller;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import com.lisotti.topic3.model.User;
import com.lisotti.topic3.service.CartService;
import com.lisotti.topic3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET, produces = "application/json")
    public Cart createCart(String username, String pass) {
        User u = new User(username,pass);
        userService.register(u);

        Cart c = new Cart(u.getId());
        cartService.addCart(c);

        return c;
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET, produces = "application/json")
    public Cart getCart(Integer cartId, String productName ){
        Product p = new Product(productName);
        cartService.addProduct(p, cartId);

        return cartService.getCart(cartId);

    }

    // falta añadir eliminar producto y ver carrito


}
