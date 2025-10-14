package com.xq.utils;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理器 包括 开启事务 提交事务 回滚事务 释放资源
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    ConnectionUtils connectionUtils;

    //开启事务并关闭事务自动提交
    public void beginTransaction() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //开启事务提交
    public void commitTransaction() {
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //回滚事务
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放资源
    public void release() {
        try {
            connectionUtils.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
