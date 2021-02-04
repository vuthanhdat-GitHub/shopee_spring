package com.example.shopeespring.controller;

import com.example.shopeespring.dto.ReceiptDetail;
import com.example.shopeespring.entity.Receipt;
import com.example.shopeespring.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptDetailController {
    @Autowired
    ReceiptDetailService receiptDetailService;
    @GetMapping("/getAll")
    public List<Receipt> getAll(){
        return receiptDetailService.GetAll();
    }
    @PostMapping("/create")
    public Boolean Create(@RequestBody Receipt receipt){
        return receiptDetailService.Create(receipt);
    }
}
