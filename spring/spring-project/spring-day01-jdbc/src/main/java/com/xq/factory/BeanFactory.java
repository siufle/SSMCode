package com.xq.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 工厂类 用于创建对象
 */
public class BeanFactory {
    static Properties properties;
    static Map<String,Object> beans;

    //读取properties配置文件中的信息
    static {
        //类加载器加载类路径下面的配置文件
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        properties = new Properties();
        try {
            properties.load(is);
            //将properties中读取的对象存储到beans中
            beans = new HashMap<>();
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String value = properties.getProperty(key);
                Object o = Class.forName(value).newInstance();
                beans.put(key,o);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public static Object getBean(String name) {
        String value = properties.getProperty(name);
        try {
            Object o = Class.forName(value).newInstance();
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    public static Object getBean(String name) {
        return beans.get(name);
    }
}
