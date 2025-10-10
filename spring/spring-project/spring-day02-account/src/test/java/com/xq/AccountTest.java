package com.xq;

import com.xq.pojo.Account;
import com.xq.service.AccountService;
import com.xq.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = (AccountService) ac.getBean("accountService");
        /*List<Account> allAccount = service.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }*/

        /*Account account = service.findAccountById(1);
        System.out.println(account);*/

        /*Account account = new Account();
        account.setName("wangwu");
        account.setMoney(1200.0);
        service.saveAccount(account);*/

        /*Account account = new Account();
        account.setId(3);
        account.setName("wangwu");
        account.setMoney(1500.0);
        service.updateAccount(account);*/

        service.deleteAccount(3);
    }
}
