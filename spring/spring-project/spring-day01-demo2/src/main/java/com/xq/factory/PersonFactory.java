package com.xq.factory;

import com.xq.dao.PersonDao;
import com.xq.dao.impl.PersonDaoImpl;

public class PersonFactory {
    public PersonDao getPersonDao() {
        return new PersonDaoImpl();
    }
}
