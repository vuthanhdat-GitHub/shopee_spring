package com.example.shopeespring.helper;

import com.example.shopeespring.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getString("productID"));
        product.setDisplay(resultSet.getString("display"));
        product.setPriceIn(resultSet.getInt("priceIn"));
        product.setPriceOut(resultSet.getInt("priceOut"));
        product.setPriceSale(resultSet.getInt("priceSale"));
        product.setAmount(resultSet.getInt("amount"));
        product.setShipDay(resultSet.getInt("shipday"));
        product.setDescription(resultSet.getString("description"));
        product.setImages(resultSet.getString("images"));
        return product;
    }
}
