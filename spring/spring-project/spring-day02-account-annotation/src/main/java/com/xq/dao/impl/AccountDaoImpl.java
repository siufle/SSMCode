package com.xq.dao.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    //操作数据库的核心类
    @Autowired
    private QueryRunner qr;

    @Override
    public List<Account> findAllAccount() {
        try {
            String sql = "select * from account";
            List<Account> accountList = qr.query(sql, new BeanListHandler<Account>(Account.class));
            return accountList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            String sql = "select * from account where id=?";
            Account account = qr.query(sql, new BeanHandler<Account>(Account.class), accountId);
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            String sql = "insert into account(name,money) values(?,?)";
            String name = account.getName();
            Double money = account.getMoney();
            qr.update(sql,name,money);
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
            qr.update(sql,name,money,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            String sql = "delete from account where id=?";
            qr.update(sql,accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
