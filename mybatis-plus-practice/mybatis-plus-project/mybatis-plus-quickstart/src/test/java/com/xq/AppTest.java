package com.xq;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.xq.mapper.UserMapper;
import com.xq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class AppTest {

    //使用原生的Mybatis测试
    @Test
    public void test01() throws Exception{
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1L);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test02() throws Exception{
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        MybatisSqlSessionFactoryBuilder builder = new MybatisSqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(2L);
        System.out.println(user);
        sqlSession.close();
    }
}
