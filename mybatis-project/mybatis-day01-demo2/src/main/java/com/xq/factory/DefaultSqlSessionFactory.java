package com.xq.factory;

import com.xq.cfg.Configuration;
import com.xq.sqlSession.DefaultSqlSession;
import com.xq.sqlSession.SqlSession;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory() {
    }

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
