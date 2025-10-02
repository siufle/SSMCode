package com.xq.dao.impl;

import com.xq.dao.AccountDao;

public class MybatisAccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("通过Mybatis增加Account");
    }
}
