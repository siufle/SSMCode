package com.xq.dao.impl;

import com.xq.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void addOrder() {
        System.out.println("新增Order方法被调用");
    }
}
