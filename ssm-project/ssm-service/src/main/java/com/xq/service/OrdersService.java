package com.xq.service;

import com.xq.pojo.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll();

    Orders findById(Integer id);
}
