package com.example.shopeespring.controller;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {

    private Account user;

    @Autowired
    AccountService accountService;
    @ModelAttribute("BeforeRequest")
    public void getUserById(HttpServletRequest httpServletRequest) throws IOException {
        user = accountService.getAccountById((String)httpServletRequest.getAttribute("user_id"));
        System.out.println(user.toString());
    }
    public Account getUserDetail(){
        return this.getUserDetail();
    }
}
