package com.xq.dao.impl;

import com.xq.dao.AccountDao;
import org.springframework.stereotype.Repository;

//@Component(value = "accountDao")
@Repository //用于数据持久层
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("新增账户的方法2222222被实现");
    }
}
