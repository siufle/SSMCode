package com.xq.service.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
/**
 *  @Transactional 可以修饰类 也可以修饰方法
 *  修饰类 则该类中全部方法都受事务控制 且事务隔离级别和事务传播行为都是同一种
 *  修饰方法 则只有当前方法受事务控制
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public void transfer(final String sourceName, final String targetName, final double money) {

        //查询转账方信息
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //查询收款方信息
        Account targetAccount = accountDao.findAccountByName(targetName);
        if (sourceAccount.getMoney() >= money) {
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            accountDao.updateAccount(sourceAccount);
            //int i = 20/0;
            accountDao.updateAccount(targetAccount);
        }
    }
}
