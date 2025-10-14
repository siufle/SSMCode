package com.xq;

import com.xq.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTest {

    @Autowired
    @Qualifier("proxy") //指定获取名为proxy的对象
    private AccountService accountService;

    @Test
    public void test() {
        String sourceName = "zhangsan";
        String targetName = "lisi";
        accountService.transfer(sourceName,targetName,200);
    }
}
