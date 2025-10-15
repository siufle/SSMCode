package com.xq.service.impl;

import com.xq.dao.AccountDao;
import com.xq.pojo.Account;
import com.xq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void transfer(final String sourceName, final String targetName, final double money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //查询转账方信息
                Account sourceAccount = accountDao.findAccountByName(sourceName);
                //查询收款方信息
                Account targetAccount = accountDao.findAccountByName(targetName);
                if(sourceAccount.getMoney() >= money) {
                    sourceAccount.setMoney(sourceAccount.getMoney() - money);
                    targetAccount.setMoney(targetAccount.getMoney() + money);
                    accountDao.updateAccount(sourceAccount);
                    //int i = 20/0;
                    accountDao.updateAccount(targetAccount);
                }
            }
        });

    }
}
