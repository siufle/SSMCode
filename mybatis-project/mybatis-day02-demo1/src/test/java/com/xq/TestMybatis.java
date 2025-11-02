package com.xq;

import com.xq.dao.UserDao;
import com.xq.pojo.QueryVo;
import com.xq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    SqlSession sqlSession;

    UserDao userDao;

    InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void test1() throws IOException {
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void test2() throws IOException {
        User user = userDao.findUserById(42);
        System.out.println(user);
    }

    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setUsername("周六");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setSex("男");
        user.setAddress("南昌");
        userDao.addUser(user);
        System.out.println("新增用户的id " + user.getId());
        sqlSession.commit();
    }

    @Test
    public void test4() throws IOException {
        User user = new User();
        user.setId(51);
        user.setUsername("李四");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setSex("女");
        user.setAddress("合肥");
        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void test5() throws IOException {
        userDao.deleteUser(52);
        sqlSession.commit();
    }

    @Test
    public void test6() throws IOException {
        List<User> users = userDao.findUserByName("%王%");
        users.forEach(System.out::println);
    }

    @Test
    public void test7() throws IOException {
        int count = userDao.getTotal();
        System.out.println(count);
    }

    @Test
    public void test8() throws IOException {
        List<User> users = userDao.findUSerBySexAndAddress("女","上海");
        users.forEach(System.out::println);
    }

    @Test
    public void test9() throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("sex","女");
        map.put("address","上海");
        List<User> users = userDao.findUSerByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void test10() throws IOException {
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(43);
        ids.add(45);
        ids.add(50);
        queryVo.setIds(ids);
        List<User> users = userDao.findUserByIds(queryVo);
        users.forEach(System.out::println);
    }
}
