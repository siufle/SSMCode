package com.xq.dao;

import com.xq.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll();

    @Insert("INSERT INTO " +
            "product(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "VALUES(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findProductById(Integer id);
}
