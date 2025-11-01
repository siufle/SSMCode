package com.xq.sqlSession;

import com.xq.cfg.Mapper;

public interface SqlSession {

    public <T> T getMapper(Class<T> tClass);

    public void close();
}
