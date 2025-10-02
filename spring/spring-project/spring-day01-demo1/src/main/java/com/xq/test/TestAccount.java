package com.xq.test;

import com.xq.dao.AccountDao;
import com.xq.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    public static void main(String[] args) {
        //读取spring配置文件 初始化ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        accountDao.addAccount();
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.addAccount();
    }
}
