package com.xq;

import com.xq.config.SpringConfiguration;
import com.xq.pojo.Account;
import com.xq.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountTeat {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService) context.getBean("accountService");
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
}
