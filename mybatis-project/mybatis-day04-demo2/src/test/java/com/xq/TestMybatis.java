package com.xq;

import com.xq.dao.UserDao;
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
    public void test01() throws IOException {
        List<User> userList = userDao.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void test02() throws IOException {
        User user = new User();
        user.setUsername("钱七");
        user.setBirthday(new Date(new java.util.Date().getTime()));
        user.setSex("男");
        user.setAddress("北京");
        userDao.addUser(user);
        System.out.println("新增用户id为" + user.getId());
    }

}
