package com.sklepmuzyczny.demo.controller;

import com.sklepmuzyczny.demo.DTO.ProductDTO;
import com.sklepmuzyczny.demo.model.Product;
import com.sklepmuzyczny.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        List<Product> list = productService.getProducts();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        productService.addNewProduct(product);

        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") long id) {
        productService.deleteById(id);
    }


    @PostMapping("/newProduct")
    public Product addNewProduct(@RequestBody ProductDTO productDTO) {

        Product product = new Product();
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductName(productDTO.getProductName());
        product.setManufacturerName(productDTO.getManufactureName());
        product.setCategory(productDTO.getCategory());

        productService.addNewProduct(product);
        return product;

    }
}
