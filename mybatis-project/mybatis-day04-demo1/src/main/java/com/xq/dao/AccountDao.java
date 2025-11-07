package com.xq.dao;

import com.xq.pojo.Account;

import java.util.List;

public interface AccountDao {

    /*public List<Account> findAccount();*/

    public List<Account> getAccountByUId(Integer id);

}
