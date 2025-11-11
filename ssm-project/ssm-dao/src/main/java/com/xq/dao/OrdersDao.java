package com.xq.dao;

import com.xq.pojo.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface OrdersDao {

    @Results(id = "ordersMap",value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.xq.dao.ProductDao.findProductById"))
    })
    @Select("select * from orders")
    List<Orders> findAll();


    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.xq.dao.ProductDao.findProductById")),
            @Result(column = "memberId", property = "member",
                    one = @One(select = "com.xq.dao.MemberDao.findMemberById")),
            @Result(column = "id", property = "travellers",
                    many = @Many(select = "com.xq.dao.TravellerDao.findTravellersByOrdersId"))
    })
    @Select("select * from orders where id = #{id}")
    Orders findById(Integer id);
}
