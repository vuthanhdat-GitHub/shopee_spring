package com.example.shopeespring.service;

import com.example.shopeespring.entity.Product;
import com.example.shopeespring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        try {
            return productRepository.getAllProduct();
        } catch (Exception ex) {
            return null;
        }
    }
    public Product getProductById(@RequestParam String id){
        try{
            return productRepository.getProductById(id);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean updateProduct(Product product){
        try{
            return productRepository.updateProduct(product);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean deleteProduct(String id){
        return productRepository.deleteProduct(id);
    }
}
