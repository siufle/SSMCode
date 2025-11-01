package com.xq.factory;

import com.xq.sqlSession.SqlSession;

public interface SqlSessionFactory {

    public SqlSession openSession();
}
