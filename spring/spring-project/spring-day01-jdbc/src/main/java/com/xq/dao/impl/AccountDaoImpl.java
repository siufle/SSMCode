package com.xq.dao.impl;

import com.xq.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("通过jdbc增加Account");
    }
}
