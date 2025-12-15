package com.xq.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xq.dao.ProvinceDao;
import com.xq.pojo.Province;
import com.xq.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String findAll() throws Exception {
        Jedis jedis = jedisPool.getResource();
        String province_name = jedis.get("province_name");
        if (StringUtils.isEmpty(province_name)) {
            //redis里数据为空 先从数据库中查询再添加进redis
            List<Province> provinceList = provinceDao.findAll();
            //转成json格式
            ObjectMapper mapper = new ObjectMapper();
            province_name = mapper.writeValueAsString(provinceList);
            jedis.set("province_name", province_name);
            return province_name;
        }
        return province_name;
    }
}
