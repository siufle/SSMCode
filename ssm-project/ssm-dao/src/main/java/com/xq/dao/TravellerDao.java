package com.xq.dao;

import com.xq.pojo.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in " +
            "(select travellerid from order_traveller where orderid = #{ordersId})")
    List<Traveller> findTravellersByOrdersId(Integer ordersId);
}
