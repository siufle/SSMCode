package com.xq.dao.impl;

import com.xq.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void addPerson() {
        System.out.println("新增person的方法被调用");
    }
}
