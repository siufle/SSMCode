package com.xq.dao;

import com.xq.pojo.Account;

public interface AccountDao {

    public Account findAccountByName(String name);

    public void updateAccount(Account account);
}
