package com.xq;

import com.xq.dao.AccountDao;
import com.xq.pojo.Animal;
import com.xq.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {

    @Test
    public void Test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        accountService.addAccount();*/
        /*AccountDao accountDao = (AccountDao) ac.getBean("accountDaoImpl");
        accountDao.addAccount();*/

        /*Animal animal = (Animal) ac.getBean("animal");
        System.out.println(animal);*/

        /*AccountService accountService1 = (AccountService) ac.getBean("accountServiceImpl");
        AccountService accountService2 = (AccountService) ac.getBean("accountServiceImpl");
        System.out.println(accountService1 == accountService2);*/

        Animal animal = (Animal) ac.getBean("animal");
        System.out.println(animal);
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
