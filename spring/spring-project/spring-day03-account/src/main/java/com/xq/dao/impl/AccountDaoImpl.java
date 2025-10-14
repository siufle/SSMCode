package com.xq.dao.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    QueryRunner runner;

    @Autowired
    ConnectionUtils connectionUtils;

    @Override
    public Account findAccountByName(String name) {
        try {
            String sql = "select * from account where name=?";
            Account account = runner.query(connectionUtils.getConnection(),sql, new BeanHandler<>(Account.class), name);
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            String sql = "update account set name=?,money=? where id=?";
            Integer id = account.getId();
            String name = account.getName();
            Double money = account.getMoney();
            runner.update(connectionUtils.getConnection(),sql,name,money,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
