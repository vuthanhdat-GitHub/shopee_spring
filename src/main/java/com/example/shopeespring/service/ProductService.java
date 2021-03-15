package com.example.shopeespring.service;

import com.example.shopeespring.entity.Product;
import com.example.shopeespring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
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

    public List<Product> getAllProduct2(String type, int sort) {
        try {
            return productRepository.getAllProduct2(type, sort);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Product> getAllProduct3(Integer size, Integer page){
        try{
            Integer limit = size;
            Integer offset = (page - 1) * size;
            return productRepository.getAllProduct3(limit, offset);
        }catch (Exception ex){
            return null;
        }
    }

    //public Integer countProduct

    public Product getProductById(@RequestParam String id) {
        try {
            return productRepository.getProductById(id);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Product> display(@RequestParam String str){
        try{
            return productRepository.display(str);
        }catch (Exception ex){
            return null;
        }
    }

    public Boolean updateProduct(Product product) {
        try {
            return productRepository.updateProduct(product);
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean deleteProduct(String id) {
        return productRepository.deleteProduct(id);
    }

    public Product getProductByDisplay(@RequestParam String display) {
        try {
            return productRepository.getProductByDisplay(display);
        } catch (Exception ex) {
            return null;
        }
    }
}
