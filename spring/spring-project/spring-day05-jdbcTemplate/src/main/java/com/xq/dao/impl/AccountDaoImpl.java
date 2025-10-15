package com.xq.dao.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.rowmapper.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountById(Integer id) {
        String sql = "select * from account where id = ?";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper(), id);
        return accountList.get(0);
    }

    @Override
    public void addAccount(Account account) {
        String sql = "insert into account (name, money) values (?,?)";
        String name = account.getName();
        Double money = account.getMoney();
        jdbcTemplate.update(sql, name, money);
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set name = ?, money = ? where id = ?";
        Integer id = account.getId();
        String name = account.getName();
        Double money = account.getMoney();
        jdbcTemplate.update(sql, name, money, id);
    }

    @Override
    public void deleteAccountById(Integer id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
