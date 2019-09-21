package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.CartDTO;
import com.sklepmuzyczny.demo.DTO.ProductDTO;
import com.sklepmuzyczny.demo.model.Cart;
import com.sklepmuzyczny.demo.model.Product;
import com.sklepmuzyczny.demo.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cart> getAllCarts() {
        List<Cart> list = cartService.getCarts();

        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart getCartById(@PathVariable("id") Long id) {
        Cart cart = cartService.getCartsById(id);
        return cart;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCart(@PathVariable("id") long id) {
        cartService.deleteById(id);
    }

    @PostMapping("/newCart")
    public Cart addCart(@RequestBody CartDTO cartDTO) {

        Cart cart = new Cart();

        cartService.addNewCart(cart);
        return cart;
    }

//    @PostMapping("/addProductToCart")
//    public Cart addProductToCart(@RequestBody Product product, Cart cart) {
//
//
//        cart.getProducts();
//
//    }
}
