package com.example.shopeespring.controller;

import com.example.shopeespring.dto.login.LoginRequestDto;
import com.example.shopeespring.dto.login.LoginResponseDto;
import com.example.shopeespring.entity.Account;
import com.example.shopeespring.exception.ApiException;
import com.example.shopeespring.helper.jwt._decode.JwtUtil;
import com.example.shopeespring.service.AccountService;
import com.example.shopeespring.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AccountService accountService;
    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws ApiException{
        Account account = accountService.getAccountByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if(account == null){
            throw new ApiException("Sai tai khoan mat khau!");
        }
        String accountId = account.getAccountID();
        String token = UUID.randomUUID().toString();
        //String token = JwtUtil.generateToken(accountId);
        Boolean createSessionResult = sessionService.createSession(accountId, token);
        if(createSessionResult) {
            return new LoginResponseDto(token);
        }else{
            throw new ApiException("Dang nhap that bai, thu lai sau");
        }
    }
    @PostMapping("/login1")  // ko luu token trong database , ma hoa userId thanh token roi dung token giai ma lai thanh userId
    public String login1(@RequestBody LoginRequestDto loginRequestDto) throws ApiException {
        Account account = accountService.getAccountByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (account == null) {
            throw new ApiException("sai tai khoan hoac mat khau");
        }
        String accountId = account.getAccountID();
        String token = JwtUtil.generateToken(accountId, account.getRole());
        return token;
    }
}
