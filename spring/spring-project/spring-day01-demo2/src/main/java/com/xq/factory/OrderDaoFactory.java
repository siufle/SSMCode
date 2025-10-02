package com.xq.factory;

import com.xq.dao.OrderDao;
import com.xq.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {

    public static OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
}
