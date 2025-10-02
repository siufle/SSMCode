package com.xq.service.impl;

import com.xq.dao.AccountDao;
import com.xq.dao.impl.AccountDaoImpl;
import com.xq.factory.BeanFactory;
import com.xq.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void addAccount() {
        //AccountDao accountDao = new AccountDaoImpl();
        AccountDao accountDao = (AccountDao) BeanFactory.getBean("MybatisAccountDao");
        System.out.println(accountDao);
        accountDao.addAccount();
    }
}
