package com.xq;

import com.xq.service.AccountService;
import com.xq.service.impl.AccountServiceImpl;

public class TestAccount {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            AccountServiceImpl accountService = new AccountServiceImpl();
            accountService.addAccount();
        }

    }
}
