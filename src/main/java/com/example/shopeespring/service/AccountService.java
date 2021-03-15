package com.example.shopeespring.service;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
@Service
public class AccountService {
    public static int index = 0;
    public static HashMap<Integer, Account> ListLogin = new HashMap<>();
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

    public Account getAccountByEmailAndPassword(String email, String password){
        return accountRepository.getAccountByEmailAndPassWord(email, password);
    }

    public int loginAccount(Account account){
        Account acc1 = getAccountById(account.getAccountID());
        if(acc1.getEmail().equals(account.getEmail()) && acc1.getPassword().equals(account.getPassword())){
            ListLogin.put(index, account);
            index++;
            return index - 1;
        }else{
            System.out.println("khong dang nhap duoc");
        }
        return -1;
    }

    public List<Account> email(String str){
        try{
            return accountRepository.email(str);
        }catch (Exception ex){
            return null;
        }
    }

    public List<Account> display(String str){
        try{
            return accountRepository.display(str);
        }catch (Exception ex){
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
    public Boolean addAccount(Account account){
        try{
            return accountRepository.addAccount(account);
        }catch (Exception ex){
            return false;
        }
    }
}
