package com.example.shopeespring.controller;

import com.example.shopeespring.entity.Product;
import com.example.shopeespring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/test-ex")
    public Integer testException(@RequestParam Integer input) {
        return input;
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/getAllProduct2")
    public List<Product> getAllProduct2(@RequestParam String type, @RequestParam int sort) {
        return productService.getAllProduct2(type, sort);
    }

    @GetMapping("/getProductById")
    public Product getProductById(String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Boolean updateProduct(@PathVariable("id") String id, Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public Boolean deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/getProductByDisplay")
    public List<Product> getProductByDisplay(@RequestParam String display){
        return productService.getProductByDisplay(display);
    }
}
