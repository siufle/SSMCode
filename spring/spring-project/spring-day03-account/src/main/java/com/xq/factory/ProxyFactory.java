package com.xq.factory;

import com.xq.service.AccountService;
import com.xq.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类 生成代理对象
 */
public class ProxyFactory {

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionManager transactionManager;

    /**
     * 产生代理对象的方法
     * @return 代理对象
     */
    public AccountService getAccountService() {
        AccountService proxy = (AccountService) Proxy.newProxyInstance(AccountService.class.getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            if (method.getName().equals("transfer")) {
                                transactionManager.beginTransaction();
                                method.invoke(accountService, args);
                                transactionManager.commitTransaction();
                            }
                        } catch (Exception e) {
                            transactionManager.rollback();
                            e.printStackTrace();
                        } finally {
                            transactionManager.release();
                        }
                        return null;
                    }
                });
        return proxy;
    }
}
