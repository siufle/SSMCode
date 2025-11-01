package com.xq.builder;

import com.xq.cfg.Configuration;
import com.xq.factory.DefaultSqlSessionFactory;
import com.xq.factory.SqlSessionFactory;
import com.xq.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream is) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(is);
        return new DefaultSqlSessionFactory(configuration);
    }
}
