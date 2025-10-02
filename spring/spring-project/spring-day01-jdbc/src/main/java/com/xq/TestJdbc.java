package com.xq;

import com.xq.pojo.Account;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/spring";
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM account";
        //创建PreparedStatement对象 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //循环访问结果集
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double money = resultSet.getDouble("money");
            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            System.out.println(account);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
