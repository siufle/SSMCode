package com.xq;

import com.xq.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension .class)
//@ContextConfiguration("classpath:applicationContext.xml")
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml"}) //等于@ExtendWith + @ContextConfiguration
public class TestJunit5 {

    @Autowired
    AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("zhangsan","lisi",200);
    }
}
