package com.xq.test;

import com.xq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AspectjTest {

    @Autowired
    UserService userService;

    @Test
    public void test1() {
        userService.deleteUser();
    }

    @Test
    public void test2() {
        userService.findAll();
    }

    @Test
    public void test3() {
        userService.updateUser();
    }

    @Test
    public void test4() {
        userService.addUser();
    }
}
