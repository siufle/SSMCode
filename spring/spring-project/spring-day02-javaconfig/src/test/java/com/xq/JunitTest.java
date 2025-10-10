package com.xq;

import com.xq.config.SpringConfiguration;
import com.xq.pojo.Account;
import com.xq.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //测试启动器
@ContextConfiguration(classes = {SpringConfiguration.class}) //在测试模板中也引入IOC环境
public class JunitTest {

    @Autowired
    AccountService accountService;

    @Test
    public void test() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }
}
