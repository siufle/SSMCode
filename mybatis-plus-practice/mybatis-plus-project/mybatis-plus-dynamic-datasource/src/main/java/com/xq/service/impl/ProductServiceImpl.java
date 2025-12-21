package com.xq.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.mapper.ProductMapper;
import com.xq.pojo.Product;
import com.xq.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
