package com.xq;

import com.xq.dao.UserDao;
import com.xq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis {

    SqlSession sqlSession;

    UserDao userDao;

    InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        sqlSession = factory.openSession(true);//开启自动提交
        //sqlSession = factory.openSession(ExecutorType.BATCH,false);//开启批处理并关闭自动提交
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void Test1() throws IOException {
        User user = new User();
        user.setSex("女");
        user.setAddress("上海");
        List<User> users = userDao.findByCondition(user);
        users.forEach(System.out::println);
    }

    @Test
    public void Test2() throws IOException {
        User user = new User();
        user.setSex("女");
        user.setAddress("上海");
        List<User> users = userDao.findByCondition2(user);
        users.forEach(System.out::println);
    }

    @Test
    public void Test3() throws IOException {
        User user = new User();
        user.setId(51);
        user.setSex("男");
        user.setAddress("南昌");
        userDao.updateUserByCondition(user);
    }

    @Test
    public void Test4() throws IOException {
        User user = new User();
        user.setUsername("周六");
        user.setSex("女");
        user.setAddress("上饶");
        userDao.addUserSelective(user);
    }

    //测试choose when otherwise
    @Test
    public void Test5() throws IOException {
        User user = new User();
        user.setSex("男");
        user.setAddress("上海");
        List<User> users = userDao.findByCondition3(user);
        users.forEach(System.out::println);
    }

    @Test
    public void Test6() throws IOException {
        Integer[] ids = {1,2,3,4};
        userDao.deleteUserByIds(ids);
    }

    @Test
    public void Test7() throws IOException {
        User user1 = new User();
        user1.setUsername("用户1");
        user1.setBirthday(new Date(new java.util.Date().getTime()));
        user1.setSex("男");
        user1.setAddress("地址1");

        User user2 = new User();
        user2.setUsername("用户2");
        user2.setBirthday(new Date(new java.util.Date().getTime()));
        user2.setSex("男");
        user2.setAddress("地址2");

        User user3 = new User();
        user3.setUsername("用户3");
        user3.setBirthday(new Date(new java.util.Date().getTime()));
        user3.setSex("男");
        user3.setAddress("地址3");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        for (User user : users) {
            userDao.addUser(user);
        }

        sqlSession.commit();
    }

}
