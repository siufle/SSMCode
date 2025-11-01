package com.xq;

import com.xq.builder.SqlSessionFactoryBuilder;
import com.xq.dao.UserDao;
import com.xq.factory.SqlSessionFactory;
import com.xq.io.Resources;
import com.xq.pojo.User;

import com.xq.sqlSession.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void test() throws IOException {
        //加载mybatis核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        //通过SqlSession对象生成接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        //释放资源
        session.close();
        is.close();
    }
}
