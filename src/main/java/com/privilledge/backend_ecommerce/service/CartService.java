package com.privilledge.backend_ecommerce.service;

import com.privilledge.backend_ecommerce.model.Cart;
import com.privilledge.backend_ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public void addToCart(Cart cartItem){
        cartRepository.save(cartItem);
    }

    public void deleteFromCart(Cart cartItem){
        cartRepository.delete(cartItem);
    }

    public List<Cart> getCartItems(){
        return cartRepository.findAll();
    }


}
