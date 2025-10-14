package com.xq.jdkProxy.dao.impl;

import com.xq.jdkProxy.dao.ProductDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer {

    public static void main(String[] args) {
        ProductDao producer = new Producer();
        producer.buyProduct("自己");

        ProductDao proxy = (ProductDao) Proxy.newProxyInstance(Producer.class.getClassLoader(),producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 当前代理对象的引用
             * @param method 当前执行的方法的对象
             * @param args 方法的参数
             * @return 被代理的方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("buyProduct")) {
                    method.invoke(producer, args);
                }
                return null;
            }
        });

        proxy.buyProduct("代理商");
    }
}
