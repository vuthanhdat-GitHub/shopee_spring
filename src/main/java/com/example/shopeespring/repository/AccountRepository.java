package com.example.shopeespring.repository;

import com.example.shopeespring.entity.Account;
import com.example.shopeespring.helper.AccountMapper;
import org.mindrot.jbcrypt.BCrypt;
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

    public List<Account> email(String str){
        String sql = "Select * from Account where deleted = 0 Order by email " + str + " ;";
        List<Account> list = jdbcTemplate.query(sql, new AccountMapper());
        return list;
    }

    public List<Account> display(String str){
        String sql = "Select * from Account where deleted = 0 Order by display " + str + " ;";
        List<Account> list = jdbcTemplate.query(sql, new AccountMapper());
        return list;
    }

    public Boolean addAccount(Account account) {
        String sql = "Insert into Account (accountID, email, display, password, role, avatar) Value (?, ?, ?, ?, ?, ?)";
        String hash = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12));
        Object values[] = new Object[6];
        values[0] = account.getAccountID();
        values[1] = account.getEmail();
        values[2] = account.getDisplay();
        values[3] = hash;
        values[4] = account.getRole();
        values[5] = account.getAvatar();
        jdbcTemplate.update(sql, values);
        return true;
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
