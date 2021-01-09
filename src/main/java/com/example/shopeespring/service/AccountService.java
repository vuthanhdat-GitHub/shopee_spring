package com.example.shopeespring.service;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getALlAccount() {
        try {
            return accountRepository.getAllAccount();
        } catch (Exception ex) {
            return null;
        }
    }

    public Account getAccountById(@RequestParam String id) {
        try {
            return accountRepository.getAccountById(id);
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean updateAccount(Account account) {
        try {
            return accountRepository.updateAccount(account);
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean deleteAccount(String id) {
        return accountRepository.deleteAccount(id);
    }
}
