package com.example.shopeespring.controller;

import com.example.shopeespring.dto.GetAllProductDto;
import com.example.shopeespring.entity.Product;
import com.example.shopeespring.exception.ApiException;
import com.example.shopeespring.service.AccountService;
import com.example.shopeespring.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public List<Product> getAllProduct(@RequestHeader int token) {
        if(!AccountService.ListLogin.containsKey(token)){
            return null;
        }
        return productService.getAllProduct();
    }
    @GetMapping("/all")
    public GetAllProductDto getAll(@RequestParam(required = false) String type, @RequestParam(required = false) String sort, HttpServletRequest request ) throws  ApiException {

        String userId = (String)request.getAttribute("user_id");
        System.out.println(userId);
        return productService.getAllUseToken(userId);
    }

    @SneakyThrows
    @GetMapping("/getAllProductDto")
    public GetAllProductDto getAllProductDto(@RequestParam String token){
        return productService.getAllUseToken(token);
    }

    @GetMapping("/getAllProduct2")
    public List<Product> getAllProduct2(@RequestParam String type, @RequestParam int sort) {
        return productService.getAllProduct2(type, sort);
    }

    @GetMapping("/getAllProduct3")
    public List<Product> getAllProduct3(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page){
        if(size == null){
            size = 10;
        }
        if(page == null){
            page = 1;
        }
        return productService.getAllProduct3(size, page);
    }

    @GetMapping("/getProductById")
    public Product getProductById(String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/display")
    public List<Product> display(@RequestParam String str){
        return productService.display(str);
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
    public Product getProductByDisplay(@RequestParam String display){
        return productService.getProductByDisplay(display);
    }
}
