package com.xq;

import com.github.pagehelper.PageHelper;
import com.xq.mapper.UserMapper;
import com.xq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    SqlSession sqlSession;
    UserMapper userMapper;

    //在@Test注解修饰的方法之前执行
    @Before
    public void init() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    //在@Test注解修饰的方法之后执行
    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void test01() throws Exception{
        //开启分页操作
        PageHelper.startPage(2,4);
        List<User> userList = userMapper.selectByExample(null);
        userList.forEach(System.out::println);
    }

}
