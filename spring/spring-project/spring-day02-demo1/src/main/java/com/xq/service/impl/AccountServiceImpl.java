package com.xq.service.impl;

import com.xq.dao.AccountDao;
import com.xq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

//@Component(value = "accountService")
@Service //用于服务层
//@Scope("singleton")//单例bean
@Scope("prototype")//多例bean
public class AccountServiceImpl implements AccountService {

    /*@Autowired //用于依赖注入 自动完成bean的注入
    @Qualifier("accountDaoImpl")
    private AccountDao accountDao;*/

    //@Resource(name = "accountDaoImpl") //默认按名称进行匹配
    @Resource(type = AccountDao.class, name = "accountDaoImpl2") //按类型匹配要唯一才能匹配到 否则要追加按名称匹配才行
    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount() {
        accountDao.addAccount();
        //System.out.println("service中的add方法被调用");
    }
}
