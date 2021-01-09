package com.example.shopeespring.repository;

import com.example.shopeespring.entity.Product;
import com.example.shopeespring.helper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Product> getAllProduct(){
        String sql = "Select * from Product where deleted = 0;";
        List<Product> list = jdbcTemplate.query(sql, new ProductMapper());
        return list;
    }
    public Product getProductById(String id){
        String sql = "Select * from Product where productID = ? and deleted = 0;";
        Product product = (Product) jdbcTemplate.queryForObject(sql, new ProductMapper(), new Object[]{id});
        return product;
    }
    public Boolean updateProduct(Product product){
        String sql = "Update Product set display = ?, priceIn = ?, priceOut = ?, priceSale = ?, amount = ?, shipday = ?, description = ?, images = ?, productId = ? and deleted = 0;";
        Object values[] = new Object[9];
        values[1] = product.getDisplay();
        values[2] = product.getPriceIn();
        values[3] = product.getPriceOut();
        values[4] = product.getPriceSale();
        values[5] = product.getAmount();
        values[6] = product.getShipDay();
        values[7] = product.getDescription();
        values[8] = product.getImages();
        values[9] = product.getProductId();
        jdbcTemplate.update(sql, values);
        return true;
    }
    public Boolean deleteProduct(String id){
        String sql = "Delete Product where productID = ? and deleted = 0;";
        jdbcTemplate.update(sql, new Object[]{id});
        return true;
    }
}
