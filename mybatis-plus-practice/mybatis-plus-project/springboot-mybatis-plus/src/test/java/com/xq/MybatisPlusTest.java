package com.xq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xq.mapper.UserMapper;
import com.xq.pojo.SexEnum;
import com.xq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<User> userList = userMapper.selectByMap(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUsers(){
        List<Map<String, Object>> users = userMapper.getUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User(null,"zhangsan",23,"zhangsan@qq.com",0,SexEnum.MALE);
        int result = userMapper.insert(user);
        Long id = user.getUid();
        System.out.println("新插入用户id为: " + id);
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(8L);
        System.out.println(result);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        List<User> userList = page.getRecords();
        userList.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void testPage2(){
        Page<User> page = new Page<>(1,5);
        userMapper.getPageVO(page,20);
        List<User> userList = page.getRecords();
        userList.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void testEnum(){
        User user = new User();
        user.setUserName("testEnum");
        user.setAge(18);
        user.setSex(SexEnum.FEMALE);
        userMapper.insert(user);
    }
}
