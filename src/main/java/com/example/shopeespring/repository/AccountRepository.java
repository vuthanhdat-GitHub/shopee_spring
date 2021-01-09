package com.example.shopeespring.repository;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.helper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Account> getAllAccount() {
        String sql = "Select * from Account where deleted = 0;";
        List<Account> list = jdbcTemplate.query(sql, new AccountMapper());
        return list;
    }

    public Account getAccountById(String id) {
        String sql = "Select * from Account where accountID = ? and deleted = 0;";
        Account account = (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), new Object[]{id});
        return account;
    }

    public Boolean updateAccount(Account account) {
        String sql = "Update Account set email = ?, display = ?, password = ?, role = ?, avatar = ? where accountID = ? and deleted = 0;";
        Object values[] = new Object[6];
        values[1] = account.getEmail();
        values[2] = account.getDisplay();
        values[3] = account.getPassword();
        values[4] = account.getRole();
        values[5] = account.getAvatar();
        values[6] = account.getAccountID();
        jdbcTemplate.update(sql, values);
        return true;
    }

    public Boolean deleteAccount(String id) {
        String sql = "Delete Account where accountID = ? and deleted = 0;";
        jdbcTemplate.update(sql, new Object[]{id});
        return true;
    }
}
