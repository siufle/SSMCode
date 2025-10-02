package com.xq.service.impl;

import com.xq.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void addAccount() {
        System.out.println("AccountService调用addCount方法");
    }
}
