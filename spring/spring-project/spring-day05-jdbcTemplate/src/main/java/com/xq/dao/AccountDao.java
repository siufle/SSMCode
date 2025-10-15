package com.xq.dao;

import com.xq.pojo.Account;

public interface AccountDao {

    public Account getAccountById(Integer id);

    public void addAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccountById(Integer id);
}
