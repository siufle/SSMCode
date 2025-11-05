package com.xq.dao;

import com.xq.pojo.Account;
import com.xq.pojo.AccountUser;

import java.util.List;

public interface AccountDao {

    public List<Account> findAccount();
}
