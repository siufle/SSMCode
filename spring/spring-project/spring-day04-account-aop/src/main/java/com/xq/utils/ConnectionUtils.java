package com.xq.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 将当前线程对象和数据库对象进行绑定 保证业务类数据库连接对象一直是同一个连接对象
 */
@Component
public class ConnectionUtils {

    @Autowired
    DataSource dataSource;

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    //获取与当前线程绑定的数据库连接对象
    public Connection getConnection() {
        try {
            Connection conn = tl.get();
            if (conn == null) { //当前线程对象上没有绑定数据库对象
                conn = dataSource.getConnection();
                tl.set(conn); //将当前数据库连接对象绑定在线程对象上
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //将当前数据库连接对象与线程对象解绑
    public void removeConnection() {
        tl.remove();
    }
}
