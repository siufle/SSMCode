package com.xq.service.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    /**
     * 通过姓名找到转出人和转入人 判断是否存在 若都存在 判断转出人余额是否足够转出指定金额
     * 若足够 则进行转账
     * @param sourceName 转出人账户姓名
     * @param targetName 转入人账户姓名
     * @param money 转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, double money) {

        //找到转出人
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //找到转入人
        Account targetAccount = accountDao.findAccountByName(targetName);
        if(sourceAccount == null || targetAccount == null) {
            System.out.println("转出人或转入人姓名输入错误 无法找到对应账户");
            return;
        }
        //判断转出人余额是否足够转出指定金额
        if(sourceAccount.getMoney() >= money) {
            //执行转账操作
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //更新账户信息
            accountDao.updateAccount(sourceAccount);
            //int n = 10 / 0;
            accountDao.updateAccount(targetAccount);
        }
    }
}
