package com.xq.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyObject {
    public static void main(String[] args) {
        final Provider provider = new Provider();
        provider.buyProduct("自己");

        Provider proxy = (Provider) Enhancer.create(Provider.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("buyProduct")) {
                    return methodProxy.invokeSuper(o, objects);
                }
                return null;
            }
        });

        proxy.buyProduct("代理商");
    }
}
