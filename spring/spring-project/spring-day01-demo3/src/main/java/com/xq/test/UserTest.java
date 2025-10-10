package com.xq.test;

import com.xq.pojo.Emp;
import com.xq.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*User user = (User) context.getBean("user");
        System.out.println(user);*/
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
    }
}
