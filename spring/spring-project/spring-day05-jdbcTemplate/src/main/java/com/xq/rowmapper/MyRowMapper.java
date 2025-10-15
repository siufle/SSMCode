package com.xq.rowmapper;

import com.xq.pojo.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double money = rs.getDouble("money");
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        return account;
    }
}
