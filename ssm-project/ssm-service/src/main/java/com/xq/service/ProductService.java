package com.xq.service;

import com.xq.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);
}
