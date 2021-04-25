package com.example.shopeespring.dto;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductDto {
    List<Product> products;
    Account account;
}
