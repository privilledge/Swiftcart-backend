package com.privilledge.backend_ecommerce.repository;


import com.privilledge.backend_ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
   Optional<Cart> findItemByName(String name);}
