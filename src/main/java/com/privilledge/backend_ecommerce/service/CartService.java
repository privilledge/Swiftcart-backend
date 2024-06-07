package com.privilledge.backend_ecommerce.service;

import com.privilledge.backend_ecommerce.model.Cart;
import com.privilledge.backend_ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public void addToCart(Cart cartItem) {
        // Check if the item already exists in the cart
        Optional<Cart> existingItem = cartRepository.findById(cartItem.getId());
        if (existingItem.isPresent()) {
            // Item already exists, increment its quantity
            Cart existingCartItem = existingItem.get();
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
            cartRepository.save(existingCartItem);
        } else {
            // Item doesn't exist, add it to the cart
            cartRepository.save(cartItem);
        }
    }

    public void deleteFromCart(Cart cartItem){
        cartRepository.delete(cartItem);
    }
    public void deleteFromCartById(Long itemId){
        cartRepository.deleteById(itemId);
    }
    public void updateItemQuantity(Cart cartItem){cartRepository.save(cartItem);}
    public List<Cart> getCartItems(){
        return cartRepository.findAll();
    }


}
