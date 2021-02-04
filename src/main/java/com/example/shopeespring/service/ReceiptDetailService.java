package com.example.shopeespring.service;

import com.example.shopeespring.entity.Receipt;
import com.example.shopeespring.repository.ReceiptDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptDetailService {
    @Autowired
    ReceiptDetailRepository receiptDetailRespository;
    public List<Receipt> GetAll(){
        try {
            return receiptDetailRespository.getAll();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Boolean Create(Receipt receipt){
        try {
            return receiptDetailRespository.Create(receipt);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
