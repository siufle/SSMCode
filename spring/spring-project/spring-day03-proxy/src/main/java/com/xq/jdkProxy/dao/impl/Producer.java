package com.xq.jdkProxy.dao.impl;

import com.xq.jdkProxy.dao.ProductDao;

public class Producer implements ProductDao {
    @Override
    public void buyProduct(String name) {
        System.out.println(name + "购买了产品");
    }
}
