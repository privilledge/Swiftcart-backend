package com.privilledge.backend_ecommerce.controller;


import com.privilledge.backend_ecommerce.model.Cart;
import com.privilledge.backend_ecommerce.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Cart cartItem){
        cartService.addToCart(cartItem);
    }

    @GetMapping
    public List getAllItems(){
        return cartService.getCartItems();
    }

    @DeleteMapping("/delete")
    public void deleteFromCart(Cart cartItem){
        cartService.deleteFromCart(cartItem);
    }
}
