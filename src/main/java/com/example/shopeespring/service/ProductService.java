package com.example.shopeespring.service;

import com.example.shopeespring.dto.GetAllProductDto;
import com.example.shopeespring.entity.Account;
import com.example.shopeespring.entity.Product;
import com.example.shopeespring.exception.ApiException;
import com.example.shopeespring.helper.jwt._decode.JwtUtil;
import com.example.shopeespring.repository.AccountRepository;
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
@Autowired
AccountRepository accountRepository;
    public  List<Product> getAllProduct() {
        try {
            return productRepository.getAllProduct();
        } catch (Exception ex) {
            return null;
        }
    }

    public Product getProductById(@RequestParam String id) {
        try {
            return productRepository.getProductById(id);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Product> getAllProductTypeSort(String type, int sort) {
        try {
            return productRepository.getAllProductTypeSort(type, sort);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Product> getAllProductLimitOffset(Integer size, Integer page) {
        try {
            Integer limit = size;
            Integer offset = (page - 1) * size;
            return productRepository.getAllProductLimitOffset(limit, offset);
        } catch (Exception ex) {
            return null;
        }
    }

    public GetAllProductDto getAllUseToken(String userId) throws ApiException {

        Account account = accountRepository.getAccountById(userId);
        List<Product> products;
        products = productRepository.getAllProduct();
        return new GetAllProductDto(products, account);
    }
    //public Integer countProduct

    public List<Product> display(@RequestParam String str) {
        try {
            return productRepository.display(str);
        } catch (Exception ex) {
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
