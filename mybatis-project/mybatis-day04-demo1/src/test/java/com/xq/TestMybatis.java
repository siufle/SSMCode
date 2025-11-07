package com.xq;

import com.xq.dao.AccountDao;
import com.xq.dao.UserDao;
import com.xq.pojo.Account;
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
import java.util.List;

public class TestMybatis {

    SqlSession sqlSession;

    AccountDao accountDao;

    UserDao userDao;

    InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        sqlSession = factory.openSession(true);//开启自动提交
        //sqlSession = factory.openSession(ExecutorType.BATCH,false);//开启批处理并关闭自动提交
        accountDao = sqlSession.getMapper(AccountDao.class);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        is.close();
    }

    /*@Test
    public void test01() throws IOException {
        List<Account> accountList = accountDao.findAccount();
        accountList.forEach(System.out::println);
    }*/

    @Test
    public void test02() throws IOException {
        List<User> userList = userDao.findUser();
        userList.forEach(System.out::println);
    }
}
