package com.example.shopeespring.controller;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/getAllAccount")
    public List<Account> getAllAccount() {
        return accountService.getALlAccount();
    }

    @GetMapping("/getAccountById")
    public Account getAccountById(String id) {

        return accountService.getAccountById(id);
    }

    @PutMapping("/updateAccount/{id}")
    public Boolean updateAccount(@PathVariable("id") String id, Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public Boolean deleteAccount(@PathVariable("id") String id) {
        return accountService.deleteAccount(id);
    }
}
