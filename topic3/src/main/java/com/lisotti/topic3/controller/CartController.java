package com.lisotti.topic3.controller;

import com.lisotti.topic3.model.Cart;
import com.lisotti.topic3.model.Product;
import com.lisotti.topic3.model.User;
import com.lisotti.topic3.service.CartService;
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

    public CartController(CartService cartService) {
        this.cartService = cartService;

    }

    @RequestMapping(value = "/addCart", method = RequestMethod.GET, produces = "application/json")
    public Cart addCart() {


        return
    }
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public void getCart(){

    }

        @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public void removeCart(){

    }


}
