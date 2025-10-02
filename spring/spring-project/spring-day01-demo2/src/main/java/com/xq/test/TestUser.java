package com.xq.test;

import com.xq.dao.OrderDao;
import com.xq.dao.PersonDao;
import com.xq.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.addUser();*/
        /*PersonDao personDao = (PersonDao) context.getBean("personDao");
        personDao.addPerson();*/
        OrderDao orderDao = (OrderDao) context.getBean("orderDaoFactory");
        orderDao.addOrder();
    }
}
