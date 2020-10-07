package com.sklepmuzyczny.demo.service;


import com.sklepmuzyczny.demo.model.Cart;
import com.sklepmuzyczny.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;


    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addNewCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getCarts() {
        List<Cart> list = (List) cartRepository.findAll();
        return list;
    }

    public Cart getCartsById(Long id) {
        Cart cart = (Cart) cartRepository.findById(id).get();
        return cart;
    }

    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

}
