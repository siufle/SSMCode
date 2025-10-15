package com.xq;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.rowmapper.MyRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAccount {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        String sql = "select * from account";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper());
        accountList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        String sql = "select * from account where id = ?";
        List<Account> accountList = jdbcTemplate.query(sql, new MyRowMapper(), 1);
        accountList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        String sql = "select count(*) from account where id > ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, 3);
        System.out.println("id大于3的数量为: " + count);
    }

    @Autowired
    AccountDao accountDao;

    @Test
    public void test4() {
        Account account = accountDao.getAccountById(1);
        System.out.println(account);
    }

    @Test
    public void test5() {
        Account account = new Account();
        account.setName("qianqi");
        account.setMoney(1000.0);
        accountDao.addAccount(account);
    }

    @Test
    public void test6() {
        Account account = new Account();
        account.setId(7);
        account.setName("qianqi");
        account.setMoney(2000.0);
        accountDao.updateAccount(account);
    }

    @Test
    public void test7() {
        accountDao.deleteAccountById(7);
    }
}
