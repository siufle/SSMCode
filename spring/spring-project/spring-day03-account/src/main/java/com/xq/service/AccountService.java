package com.xq.service;

import com.xq.pojo.Account;

public interface AccountService {

    public void transfer(String sourceName, String targetName, double money);
}
