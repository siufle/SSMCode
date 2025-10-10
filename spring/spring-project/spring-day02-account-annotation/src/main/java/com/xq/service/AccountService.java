package com.xq.service;

import com.xq.pojo.Account;

import java.util.List;

public interface AccountService {
    //查询所有数据
    List<Account> findAllAccount();

    //根据账户id查询账户
    Account findAccountById(Integer accountId);

    //保存账户信息
    void saveAccount(Account account);

    //修改账户信息
    void updateAccount(Account account);

    //通过id删除账户信息
    void deleteAccount(Integer accountId);
}
