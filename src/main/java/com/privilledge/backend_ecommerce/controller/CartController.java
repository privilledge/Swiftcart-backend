package com.privilledge.backend_ecommerce.controller;


import com.privilledge.backend_ecommerce.model.Cart;
import com.privilledge.backend_ecommerce.service.CartService;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/delete")
    public void deleteFromCart(@RequestBody Cart cartItem){
        cartService.deleteFromCart(cartItem);
    }
    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId){
        cartService.deleteFromCartById(itemId);
        return ResponseEntity.ok("Item deleted from cart");
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateItemQuantity(@RequestBody Cart cartItem) {
        cartService.updateItemQuantity(cartItem);
        return ResponseEntity.ok("Item updated");
    }

}
